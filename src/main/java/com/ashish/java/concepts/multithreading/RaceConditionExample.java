package com.ashish.java.concepts.multithreading;

class SharedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class RaceConditionExample {

    static void main() {
        SharedCounter sharedCounter = new SharedCounter();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread one started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread two started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + sharedCounter.getCount());
    }
}
