package com.hello;

public class VolatileDemo {
    private static  boolean flag = false; // Declared as volatile

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: Modifies the flag
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flag = true; // Set the flag to true
            System.out.println("Writer Thread: Flag set to true.");
        });

        // Thread 2: Reads the flag
        Thread readerThread = new Thread(() -> {
            System.out.println("Reader Thread: Waiting for flag to be true...");
            while (!flag) {
                // Busy-wait until flag becomes true
            }
            System.out.println("Reader Thread: Flag is now true. Exiting loop.");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join(); // Wait for writer thread to finish
        readerThread.join(); // Wait for reader thread to finish

        System.out.println("Main Thread: Program finished.");
    }
}