package com.ashish.java.concepts.multithreading;

import java.util.concurrent.CountDownLatch;

public class VirtualThreadExample {

    static void main() throws InterruptedException {
        Thread virtuaThread = Thread.startVirtualThread(() -> {
            System.out.println("Running task with virtual thread : " + Thread.currentThread().getName());
        });

        virtuaThread.join();


        int numberOfThreads = 1_000_00;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfThreads; i++) {
            // Simulate some work
            Thread.startVirtualThread(latch::countDown);
        }
        latch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to complete " + numberOfThreads + " virtual threads: " + (endTime - startTime) + " ms");

        CountDownLatch platformLatch = new CountDownLatch(numberOfThreads);
        long platformStartTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfThreads; i++) {
            // Simulate some work
            new Thread(platformLatch::countDown).start();
        }
        platformLatch.await();
        long platformEndTime = System.currentTimeMillis();
        System.out.println("Time taken to complete " + numberOfThreads + " platform threads: " + (platformEndTime - platformStartTime) + " ms");

    }
}
