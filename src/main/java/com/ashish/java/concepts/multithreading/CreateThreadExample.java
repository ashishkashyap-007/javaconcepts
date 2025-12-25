package com.ashish.java.concepts.multithreading;

public class CreateThreadExample {

    static void main() {
        Thread thread = new Thread(() -> {
            // Code to be executed by the thread
            System.out.println("Thread 1 is running : " + Thread.currentThread().getName());
        });

        // Start the thread
        thread.start();

        Runnable runnable = () -> {
            // Code to be executed by the thread
            System.out.println("Thread 2 is running : " + Thread.currentThread().getName());
            System.out.println("Current state of Thread 2: " + Thread.currentThread().getState());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 2 has finished execution.");
        };

        Thread threadObj = new Thread(runnable, "Runnable-Thread");
        // Start the thread
        threadObj.start();
    }
}
