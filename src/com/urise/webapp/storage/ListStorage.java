package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return 0;
    }


    @Override
    protected void updating(Resume r,int index) {
        list.set(index, r);
    }

    @Override
    protected void insertResume(Resume r, int index) {
        list.add(index, r);
    }


    @Override
    protected void deleting(int index) {
        list.remove(index);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected Resume getting(String uuid) {
        return list.get(getIndex(uuid));
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }



    @Override
    public int size() {
        return list.size();
    }
}
