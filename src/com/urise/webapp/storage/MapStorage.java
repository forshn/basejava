package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected boolean isExist(Resume resume) {
        return map.containsValue(resume);
    }

    @Override
    protected Resume getSearchedKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.replace(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }
}
