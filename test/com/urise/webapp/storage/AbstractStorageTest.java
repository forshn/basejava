package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.utils.Config;
import com.urise.webapp.utils.ResumeTestData;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static com.urise.webapp.model.ContactType.*;

public abstract class AbstractStorageTest {
    protected final static File STORAGE_DIR = Config.get().getStorageDir();
    protected Storage storage;

    private final String UUID_1 = UUID.randomUUID().toString();
    private final String UUID_2 = UUID.randomUUID().toString();
    private final String UUID_3 = UUID.randomUUID().toString();
    private final String UUID_4 = UUID.randomUUID().toString();

    private final Resume RESUME_1;
    private final Resume RESUME_2;
    private final Resume RESUME_3;
    private final Resume RESUME_4;

    {
        RESUME_1 = ResumeTestData.getResume(UUID_1, "Name1");
        RESUME_2 = ResumeTestData.getResume(UUID_2, "Name2");
        RESUME_3 = ResumeTestData.getResume(UUID_3, "Name3");
        RESUME_4 = ResumeTestData.getResume(UUID_4, "Name4");
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_1, "Nikolay");
        resume.addContact(TEL, "123");
        resume.addContact(SKYPE, "Forsh");
        resume.addContact(MAIL, "forsh_nikolay@mail.ru");
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void notExistToUpdate() throws NotExistStorageException {
        storage.update(new Resume("newUUid", "newName"));
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        List<Resume> sortedResumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        Collections.sort(sortedResumes);
        assertEquals(list, sortedResumes);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = StorageException.class)
    public void saveExistingResume() throws Exception {
        storage.save(new Resume(UUID_2, "Angela"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_2);
        assertEquals(2, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistingResume() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}