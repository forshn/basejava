package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object resume = getExistingResume(r.getUuid());
        doUpdate(r, resume);
    }

    public void save(Resume r) {
        Object resume = getNotExistingResume(r.getUuid());
        doSave(r, resume);
    }

     public void delete(String uuid) {
        Object resume = getExistingResume(uuid);
        doDelete(resume);
    }

    public Resume get(String uuid) {
        Object resume = getExistingResume(uuid);
        return doGet(resume);
    }

    protected abstract boolean isExist(Object index);

    private Object getExistingResume(String uuid) {
        Object resume = getIndexOrKey(uuid);
        if (!isExist(resume)) {
            throw new NotExistStorageException(uuid);
        }
        return resume;
    }

    private Object getNotExistingResume(String uuid) {
        Object resume = getIndexOrKey(uuid);
        if (isExist(resume)) {
            throw new ExistStorageException(uuid);
        }
        return resume;
    }

    protected abstract Object getIndexOrKey(String uuid);

    protected abstract void doUpdate(Resume r, Object resume);

    protected abstract void doSave(Resume r, Object resume);

    protected abstract void doDelete(Object resume);

    protected abstract Resume doGet(Object resume);
}