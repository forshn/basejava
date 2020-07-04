package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected void doSave(Resume r, Object resume) {
        list.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        list.set((Integer) resume, r);
    }

    @Override
    protected void doDelete(Object resume) {
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
    protected Resume doGet(Object resume) {
        return list.get((Integer) resume);
    }

    @Override
    protected boolean isExist(Object index) {
        return index != null;
    }

    @Override
    protected Integer getSearchedKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }
}
