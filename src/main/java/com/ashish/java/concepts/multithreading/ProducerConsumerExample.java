package com.ashish.java.concepts.multithreading;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {
    private List<Integer> buffer;

    public Producer(List<Integer> queue) {
        this.buffer = queue;
    }

    @Override
    public void run() {
        int item = 1;
        while (true) {
            try {
                produce(item++);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void produce(int item) throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == ProducerConsumerExample.BUFFER_SIZE) {
                System.out.println("Buffer is full, waiting for consumer to consume...");
                buffer.wait();
            }
            buffer.add(item);
            System.out.println("Produced: " + item);
            buffer.wait(1000); // Simulate time taken to produce
            buffer.notifyAll();
        }
    }
}


class Consumer implements Runnable {

    private List<Integer> buffer;

    public Consumer(List<Integer> queue) {
        this.buffer = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty, waiting for producer to produce...");
                buffer.wait();
            }
            int item = buffer.removeFirst();
            System.out.println("Consumed: " + item);
            buffer.wait(2000); // Simulate time taken to consume
            buffer.notifyAll();
        }
    }

}

public class ProducerConsumerExample {
    //let's solve the producer consumer problem using synchronized keyword and wait notify methods
    static final int BUFFER_SIZE = 10;
    private static List<Integer> buffer = new ArrayList<>(BUFFER_SIZE);

    static void main() {
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

