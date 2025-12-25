package com.ashish.java.concepts.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServiceExample {

    static void main() {
        //Fixed Thread Pool Example
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println("\nFixed Thread Pool Example:");

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Executing Fixed Thread Pool Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        //
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("\nCached Thread Pool Example:");

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedThreadPool.execute(() -> {
                System.out.println("Executing Cached Thread Pool Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        //Single Thread Executor Example
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("\nSingle Thread Executor Example:");

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("Executing Single Thread Executor Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        //Scheduled Thread Pool Example
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("\nScheduled Thread Pool Example:");

        scheduledThreadPool.schedule(() -> System.out.println("Executing Scheduled Task by " + Thread.currentThread().getName()),
                3,
                java.util.concurrent.TimeUnit.SECONDS);

        // Shutdown all executors
        fixedThreadPool.shutdown();
        cachedThreadPool.shutdown();
        singleThreadExecutor.shutdown();
        scheduledThreadPool.shutdown();
    }
}
