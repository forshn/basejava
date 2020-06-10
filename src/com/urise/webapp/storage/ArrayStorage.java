package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void offsetArray(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}