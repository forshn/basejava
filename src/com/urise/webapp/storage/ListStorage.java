package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected void doSave(Resume r, Integer resume) {
        list.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Integer resume) {
        list.set(resume, r);
    }

    @Override
    protected List<Resume> doGetAll() {
        return list;
    }

    @Override
    protected void doDelete(Integer resume) {
        list.remove(resume.intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected Resume doGet(Integer resume) {
        return list.get(resume);
    }

    @Override
    protected boolean isExist(Integer index) {
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
