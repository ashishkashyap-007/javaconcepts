package com.ashish.java.concepts.multithreading;

public class DaemonThreadExample {

    static void main() {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon Thread is running...");
                try {
                    Thread.sleep(1000); // simulate some work
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
