package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int counterOfResumes = 0;

    void clear() {
        Arrays.fill(storage, 0, counterOfResumes, null);
    }

    void update(Resume r) {
    }

    boolean hasResume(String uuid) {
        boolean hasResume = true;
        for (int i = 0; i < counterOfResumes; i++) {
            if (uuid.equals(storage[i].toString())) {
                hasResume = false;
                break;
            }
        }
        return hasResume;
    }

    void save(Resume r) {
        if (!hasResume(r.toString())) {
            System.out.println("ERROR: " + r.getUuid() + " already exists");
        } else if (counterOfResumes < storage.length) {
            storage[counterOfResumes] = r;
            counterOfResumes++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    Resume get(String uuid) {
        if (!hasResume(uuid)) {
            for (int i = 0; i < counterOfResumes; i++) {
                if (uuid.equals(storage[i].toString())) {
                    return storage[i];
                }
            }
        } else System.out.println("ERROR: " + uuid.toString() + " doesn't exist");
        return null;
    }

    void delete(String uuid) {
        if (!hasResume(uuid)) {
            for (int i = 0; i < counterOfResumes; i++) {
                if (uuid.equals(storage[i].toString())) {
                    System.arraycopy(storage, i + 1, storage, i, counterOfResumes - 1);
                    counterOfResumes--;
                }
                break;
            }
        } else System.out.println("ERROR: " + uuid.toString() + " doesn't exist");
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, counterOfResumes);
    }

    int size() {
        return counterOfResumes;
    }
}


