package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int counterOfResumes = 0;
    private int currentIndex;

    void clear() {
        Arrays.fill(storage, 0, counterOfResumes, null);
        counterOfResumes = 0;
    }

    Scanner scan = new Scanner(System.in);

    void update(Resume r) {
        String newUuid;
        if (isExistingResume(r.toString())) {
            do {
                System.out.println("Enter new Resume");
                newUuid = scan.nextLine();
                if (isExistingResume(newUuid)) {
                    System.out.println("Duplicate resume, update has been rejected");
                    break;
                } else r.setUuid(newUuid);
                System.out.println("Update has been completed");
            } while (!isExistingResume(r.toString()));
        }
        if (!isExistingResume(r.toString())) {
            System.out.println("ERROR: " + r.toString() + " doesn't exist");
        }
    }

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

    void save(Resume r) {
        if (isExistingResume(r.toString())) {
            System.out.println("ERROR: " + r.getUuid() + " already exists");
        } else if (counterOfResumes < storage.length) {
            storage[counterOfResumes] = r;
            counterOfResumes++;
        } else System.out.println("Сохранение резюме невозможно, база переполнена.");
    }

    Resume get(String uuid) {
        if (isExistingResume(uuid)) {
            return storage[currentIndex];
        } else System.out.println("ERROR: " + uuid + " doesn't exist");
        return null;
    }

    void delete(String uuid) {
        if (isExistingResume(uuid)) {
            System.arraycopy(storage, currentIndex + 1, storage, currentIndex, counterOfResumes - 1);
            counterOfResumes--;
        } else System.out.println("ERROR: " + uuid + " doesn't exist");
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, counterOfResumes);
    }

    int size() {
        return counterOfResumes;
    }
}


