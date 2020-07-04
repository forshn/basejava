package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import static org.junit.Assert.assertEquals;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    public void getAll() throws Exception {
        Resume[] actualResumes = storage.getAll();
        assertEquals(3, actualResumes.length);

    }
}

