package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object resume = existingResume(r.getUuid());
        updating(r, resume);
    }

    public void save(Resume r) {
        Object resume = nonexistentResume(r.getUuid());
        saving(r, resume);
    }

     public void delete(String uuid) {
        Object resume = existingResume(uuid);
        deleting(resume);
    }

    public Resume get(String uuid) {
        Object resume = existingResume(uuid);
        return getting(resume);
    }

    protected abstract boolean isExist(Object index);

    private Object existingResume(String uuid) {
        Object resume = getResume(uuid);
        if (!isExist(resume)) {
            throw new NotExistStorageException(uuid);
        }
        return resume;
    }

    private Object nonexistentResume(String uuid) {
        Object resume = getResume(uuid);
        if (isExist(resume)) {
            throw new ExistStorageException(uuid);
        }
        return resume;
    }

    protected abstract Object getResume(String uuid);

    protected abstract void updating(Resume r, Object resume);

    protected abstract void saving(Resume r, Object resume);

    protected abstract void deleting(Object resume);

    public abstract void clear();

    protected abstract Resume getting(Object resume);
}