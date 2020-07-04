package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object resume = getExistingSearchedKey(r.getUuid());
        doUpdate(r, resume);
    }

    public void save(Resume r) {
        Object resume = getNotExistedSearchedKey(r.getUuid());
        doSave(r, resume);
    }

     public void delete(String uuid) {
        Object resume = getExistingSearchedKey(uuid);
        doDelete(resume);
    }

    public Resume get(String uuid) {
        Object resume = getExistingSearchedKey(uuid);
        return doGet(resume);
    }

    protected abstract boolean isExist(Object index);

    private Object getExistingSearchedKey(String uuid) {
        Object resume = getSearchedKey(uuid);
        if (!isExist(resume)) {
            throw new NotExistStorageException(uuid);
        }
        return resume;
    }

    private Object getNotExistedSearchedKey(String uuid) {
        Object resume = getSearchedKey(uuid);
        if (isExist(resume)) {
            throw new ExistStorageException(uuid);
        }
        return resume;
    }

    protected abstract Object getSearchedKey(String uuid);

    protected abstract void doUpdate(Resume r, Object resume);

    protected abstract void doSave(Resume r, Object resume);

    protected abstract void doDelete(Object resume);

    protected abstract Resume doGet(Object resume);
}