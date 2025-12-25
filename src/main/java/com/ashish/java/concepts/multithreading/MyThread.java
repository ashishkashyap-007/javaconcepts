package com.ashish.java.concepts.multithreading;

public class MyThread extends Thread {

    public void run() {
        //Code to be executed by the thread
        System.out.println("Thread running : " + Thread.currentThread().getName());
    }

    static void main() {
        MyThread myThread = new MyThread();
        // Start the thread
        myThread.start();
    }
}
