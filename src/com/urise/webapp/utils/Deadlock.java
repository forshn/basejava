package com.urise.webapp.utils;

public class Deadlock {
    private final static String STRING1 = "TEST";
    private final static String STRING2 = "TEST1";

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> printStringsFromThreads(STRING1, STRING2));

        Thread thread2 = new Thread(() -> printStringsFromThreads(STRING2, STRING1));

        thread1.start();
        thread2.start();

    }

    private static void printStringsFromThreads(String string1, String string2) {
        synchronized (string1) {
            System.out.println("Output " + string1 + " from " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (string2) {
                System.out.println("Now output " + string2 + " from " + Thread.currentThread().getName());
            }
        }
    }
}
