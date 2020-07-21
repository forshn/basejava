package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void doUpdate(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    protected List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public void doSave(Resume resume, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflowed", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    public Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    public void doDelete(Integer index) {
        offsetArray(index);
        size--;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    public int size() {
        return size;
    }

    protected abstract void offsetArray(int index);

    protected abstract Integer getSearchedKey(String uuid);

    protected abstract void insertResume(Resume r, int index);
}