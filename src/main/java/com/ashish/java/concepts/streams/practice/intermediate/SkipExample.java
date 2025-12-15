package com.ashish.java.concepts.streams.practice.intermediate;

import java.util.Arrays;
import java.util.List;

public class SkipExample {

    public static void main(String[] args) {
        // Example of using skip() in a stream
        System.out.println("Example of skip():");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        names.stream()
                .skip(2) // Skip the first 2 elements
                .forEach(System.out::println); // Output: Charlie, David, Eve

        // Example of using skip() with filter()
        System.out.println("\nexample of skip() with filter():");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .skip(2) // Skip the first 2 even numbers
                .forEach(System.out::println); // Output: 6, 8, 10

    }
}
