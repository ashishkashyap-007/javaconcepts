package com.ashish.java.concepts.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    private static final int BUFFER_SIZE = 10;
    private static BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    static void main() {
        Thread producerThread = new Thread(new BlockingQueueExample.Producer());
        Thread consumerThread = new Thread(new BlockingQueueExample.Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                int item = 1;
                while (true) {
                    //produce items
                    buffer.put(item++);
                    System.out.println("Produced: " + (item - 1));

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    //consume items
                    int item = buffer.take();
                    System.out.println("Consumed: " + item);

                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
