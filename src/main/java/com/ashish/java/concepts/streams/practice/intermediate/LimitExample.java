package com.ashish.java.concepts.streams.practice.intermediate;

import java.util.Arrays;
import java.util.List;

public class LimitExample {

    public static void main(String[] args) {
        // Example of using limit() in Java Streams
        System.out.println("Limit Example:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .limit(5)
                .filter(num -> num % 2 != 0)
                .forEach(System.out::println); // Output: 1, 3, 5
    }
}
