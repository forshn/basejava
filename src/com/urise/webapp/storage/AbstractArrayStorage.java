package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void updating(Resume resume, Object index) {
        storage[(int) index] = resume;
    }

    @Override
    public void saving(Resume resume, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage owerflowed", resume.getUuid());
        } else {
            insertResume(resume, (int) index);
            size++;
        }
    }

    public Resume getting(Object index) {
        return storage[(int) index];
    }

    @Override
    public void deleting(Object index) {
        offsetArray((int) index);
        size--;
    }

    @Override
    protected boolean isExist(Object index) {
        return (int) index >= 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract void offsetArray(int index);

    protected abstract Integer getResume(String uuid);

    protected abstract void insertResume(Resume r, int index);
}