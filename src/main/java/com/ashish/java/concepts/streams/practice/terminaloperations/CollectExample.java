package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {

    public static void main(String[] args) {
        // Example of using collect() in Java Streams
        System.out.println("Collect Example:");

        // Collecting squared even numbers from a stream into a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenSquaredList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(evenSquaredList); // Output: [4, 16, 36, 64, 100]

        // Collecting squared even numbers from a stream into a set
        Set<Integer> evenSquaredSet = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toSet());

        System.out.println(evenSquaredSet); // Output: [4, 16, 36, 64, 100]

    }
}
