package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int counterOfResumes = 0;
    private int currentIndex = -1;

    public void clear() {
        Arrays.fill(storage, 0, counterOfResumes, null);
        counterOfResumes = 0;
    }

    public void update(Resume r) {
        if (isExistingResume(r.getUuid())) {
            storage[currentIndex] = r;
            System.out.println("Update has been completed");
        } else {
            System.out.println("Error: resume " + r.getUuid() + " wasn't found");
        }
}

    // Метод, проверяющий наличие резюме в хранилище
    boolean isExistingResume(String uuid) {
        boolean isExistingResume = false;
        for (int i = 0; i < counterOfResumes; i++) {
            if (uuid.equals(storage[i].toString())) {
                isExistingResume = true;
                currentIndex = i;
                break;
            }
        }
        return isExistingResume;
    }

    public void save(Resume r) {
        if (isExistingResume(r.getUuid())) {
            System.out.println("ERROR: " + r.getUuid() + " already exists");
        } else if (counterOfResumes < storage.length) {
            storage[counterOfResumes] = r;
            counterOfResumes++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    public Resume get(String uuid) {
        if (isExistingResume(uuid)) {
            return storage[currentIndex];
        } else System.out.println("ERROR: " + uuid + " doesn't exist");
        return null;
    }

    public void delete(String uuid) {
        if (isExistingResume(uuid)) {
            System.arraycopy(storage, currentIndex + 1, storage, currentIndex, counterOfResumes - 1);
            counterOfResumes--;
        } else System.out.println("ERROR: " + uuid + " doesn't exist");
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, counterOfResumes);
    }

    public int size() {
        return counterOfResumes;
    }
}


