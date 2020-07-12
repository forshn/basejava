package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object searchedKey = getExistingSearchedKey(r.getUuid());
        doUpdate(r, searchedKey);
    }

    public void save(Resume r) {
        Object searchedKey = getNotExistedSearchedKey(r.getUuid());
        doSave(r, searchedKey);
    }

     public void delete(String uuid) {
        Object searchedKey = getExistingSearchedKey(uuid);
        doDelete(searchedKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = doGetAll();
        Collections.sort(list);
        return list;
    }

    public Resume get(String uuid) {
        Object searchedKey = getExistingSearchedKey(uuid);
        return doGet(searchedKey);
    }

    private Object getExistingSearchedKey(String uuid) {
        Object searchedKey = getSearchedKey(uuid);
        if (!isExist(searchedKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchedKey;
    }

    private Object getNotExistedSearchedKey(String uuid) {
        Object searchedKey = getSearchedKey(uuid);
        if (isExist(searchedKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchedKey;
    }

    protected abstract Object getSearchedKey(String uuid);

    protected abstract void doUpdate(Resume r, Object searchedKey);

    protected abstract List<Resume> doGetAll();

    protected abstract boolean isExist(Object searchedKey);

    protected abstract void doSave(Resume r, Object searchedKey);

    protected abstract void doDelete(Object searchedKey);

    protected abstract Resume doGet(Object searchedKey);
}