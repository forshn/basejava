package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.seralizer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;
    private StreamSerializer streamSerializer;

    protected FileStorage(File directory, StreamSerializer streamSerializer) {
        Objects.requireNonNull(directory, "mustn't be null");
        this.streamSerializer = streamSerializer;
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "isn't directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "isn't readable/writeable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        if (getFilesArray() != null) {
            for (File file : getFilesArray()) {
                doDelete(file);
            }
        }
    }

    @Override
    public int size() {
        return getFilesArray().length;
    }

    @Override
    protected File getSearchedKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> list = new ArrayList<>(getFilesArray().length);
        for (File file : getFilesArray()) {
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    protected void doSave(Resume resume, File file) {
        if (file.exists()){
            throw new StorageException("File is already exists", resume.getUuid());
        } else doUpdate(resume, file);
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            streamSerializer.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO Error", resume.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("Delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Read error", file.getName(), e);
        }
    }

    private File[] getFilesArray() {
        try {
            return directory.listFiles();
        } catch (NullPointerException e) {
            throw new StorageException("Directory read error", e);
        }
    }
}

