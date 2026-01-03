package com.ashish.java.concepts.multithreading;

public class InheritableThreadLocal {
    private static java.lang.InheritableThreadLocal<String> inheritableThreadLocal = new java.lang.InheritableThreadLocal<>();

    static void main() {
        inheritableThreadLocal.set("This is the inheritable thread local value from main thread.");

        Thread parentThread = new Thread(() -> {
            System.out.println("Value in parent thread: " + inheritableThreadLocal.get());
            inheritableThreadLocal.remove();
            inheritableThreadLocal.set("parent thread value");

            Thread childThread = new Thread(() -> {
                System.out.println("Value in child thread: " + inheritableThreadLocal.get());
            });
            childThread.start();
            inheritableThreadLocal.remove();
        });

        parentThread.start();
    }
}
