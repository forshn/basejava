package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getResume(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void updating(Resume r, Object resume) {
        map.replace(r.getUuid(), r);
    }

 @Override
    protected void saving(Resume r, Object resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void deleting(Object resume) {
        map.remove(resume.toString());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Resume getting(Object resume) {
        return map.get(resume.toString());
    }
}
