package com.ashish.java.concepts.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

// Volatile keyword example
public class VolatileKeywordExample {
    private volatile boolean flag;

    public void setFlag(boolean value) {
        this.flag = value;
    }

    public boolean getFlag() {
        return this.flag;
    }
}

// AtomicInteger example for atomic operations
class AtomicExample {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}

// Synchronization example
class SynchronizedExample {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}


