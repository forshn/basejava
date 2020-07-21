package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void update(Resume resume) {
        LOG.info(" Update " + resume);
        SK searchedKey = getExistingSearchedKey(resume.getUuid());
        doUpdate(resume, searchedKey);
    }

    public void save(Resume resume) {
        LOG.info(" Save " + resume);
        SK searchedKey = getNotExistedSearchedKey(resume.getUuid());
        doSave(resume, searchedKey);
    }

    public void delete(String uuid) {
        LOG.info(" Delete " + uuid);
        SK searchedKey = getExistingSearchedKey(uuid);
        doDelete(searchedKey);
    }

    public List<Resume> getAllSorted() {
        LOG.info(" GetAllSorted");
        List<Resume> list = doGetAll();
        list.sort(Resume::compareTo);
        return list;
    }

    public Resume get(String uuid) {
        LOG.info(" Get " + uuid);
        SK searchedKey = getExistingSearchedKey(uuid);
        return doGet(searchedKey);
    }

    private SK getExistingSearchedKey(String uuid) {
        SK searchedKey = getSearchedKey(uuid);
        if (!isExist(searchedKey)) {
            LOG.warning("Remume " + uuid + " doesn't exist");
            throw new NotExistStorageException(uuid);
        }
        return searchedKey;
    }

    private SK getNotExistedSearchedKey(String uuid) {
        SK searchedKey = getSearchedKey(uuid);
        if (isExist(searchedKey)) {
            LOG.warning("Remume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchedKey;
    }

    protected abstract SK getSearchedKey(String uuid);

    protected abstract void doUpdate(Resume resume, SK searchedKey);

    protected abstract List<Resume> doGetAll();

    protected abstract boolean isExist(SK searchedKey);

    protected abstract void doSave(Resume resume, SK searchedKey);

    protected abstract void doDelete(SK searchedKey);

    protected abstract Resume doGet(SK searchedKey);
}