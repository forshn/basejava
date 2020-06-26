package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected void saving(Resume r, Object resume) {
        list.add(r);
    }

    @Override
    protected void updating(Resume r, Object resume) {
        list.set((Integer) resume, r);
    }

    @Override
    protected void deleting(Object resume) {
        list.remove(((Integer) resume).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    protected Resume getting(Object resume) {
        return list.get((Integer) resume);
    }

    @Override
    protected Integer getResume(String uuid) {
        Resume r = new Resume(uuid);
        if (list.contains(r)){
            return list.indexOf(r);
        }
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }
}
