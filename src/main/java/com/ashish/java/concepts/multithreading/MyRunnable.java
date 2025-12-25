package com.ashish.java.concepts.multithreading;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        // Code to be executed by the thread
        System.out.println("Thread running : " + Thread.currentThread().getName());
    }

    static void main() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);

        // Start the thread
        thread.start();
    }
}
