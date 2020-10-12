package com.urise.webapp.storage;

import com.urise.webapp.utils.Config;

public class SqlStorageTest extends AbstractStorageTest {
    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}
