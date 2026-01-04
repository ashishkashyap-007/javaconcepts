package com.ashish.java.concepts.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeTest {
    static void main() {
        // Fail-safe collections are part of java.util.concurrent package
        // Example: CopyOnWriteArrayList, ConcurrentHashMap
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();
            list.add("z"); // This will NOT cause ConcurrentModificationException
        }
    }
}
