package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected String getSearchedKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        map.replace(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
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
    protected Resume doGet(String uuid) {
        return map.get(uuid);
    }
}
