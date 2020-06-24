package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        int index = existedIndex(r.getUuid());
        updating(r, index);
    }

    public void save(Resume r) {
        int index = notExistedIndex(r.getUuid());
        insertResume(r, index);
    }

    public Resume get(String uuid) {
        int r = existedIndex(uuid);
        return getting(uuid);
    }

    public void delete(String uuid) {
        int index = existedIndex(uuid);
        deleting(index);
    }

    private int existedIndex(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return getIndex(uuid);
    }

    private int notExistedIndex(String uuid) {
        if (isExist(uuid)) {
            throw new ExistStorageException(uuid);
        }
        return getIndex(uuid);
    }

    protected boolean isExist(String uuid) {
        return getIndex(uuid) != 0;
    }

    protected abstract void updating(Resume r, int index);

    protected abstract void deleting(int index);

    protected abstract int getIndex(String uuid);

    protected abstract Resume getting(String uuid);

    protected abstract void insertResume(Resume r, int index);
}