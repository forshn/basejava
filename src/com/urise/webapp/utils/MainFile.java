package com.urise.webapp.utils;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File directory = new File(".\\src\\com\\urise\\webapp");
        printDirectoryDeeply(directory, "");
    }

    private static void printDirectoryDeeply(File directory, String space) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(space + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(space + "Directory: " + file.getName());
                    printDirectoryDeeply(file,space + "\t");
                }
            }
        }
    }
}
