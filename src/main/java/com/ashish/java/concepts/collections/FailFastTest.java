package com.ashish.java.concepts.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FailFastTest {
    // Fail-fast collections throw ConcurrentModificationException when modified during iteration
    // Example: ArrayList, HashMap
    static void main() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            Integer number = iterator.next();
            numbers.add(10); // This will cause ConcurrentModificationException
        }
    }
}
