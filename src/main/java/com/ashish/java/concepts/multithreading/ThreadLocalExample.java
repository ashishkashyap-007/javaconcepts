package com.ashish.java.concepts.multithreading;

public class ThreadLocalExample {
    private static ThreadLocal<Long> userThreadLocal = new ThreadLocal<>();

    static void main() {
        Long userId1 = 10001L;
        Long userId2 = 10002L;

        userThreadLocal.set(100L);
        System.out.println("Value in main thread: " + userThreadLocal.get());

        Thread thread1 = new Thread(() -> {
            System.out.println("Started thread for userId: " + userId1);
            userThreadLocal.set(userId1);
            System.out.println("User1 Thread local value in new thread : " + userThreadLocal.get());

            //Perform some operations
            userThreadLocal.remove();
            System.out.println("User1 Thread local value after remove in new thread : " + userThreadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Started thread for userId: " + userId2);
            userThreadLocal.set(userId2);
            System.out.println("User2 Thread local value in new thread : " + userThreadLocal.get());

            //Perform some operations
            userThreadLocal.remove();
            System.out.println("User2 Thread local value after remove in new thread : " + userThreadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
