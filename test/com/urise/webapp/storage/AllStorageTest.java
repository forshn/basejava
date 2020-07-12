package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                ListArrayStorageTest.class,
                MapUuidStorageTest.class,
                SortedArrayStorageTest.class,
                MapStorageTest.class
        }
)
public class AllStorageTest {
}
