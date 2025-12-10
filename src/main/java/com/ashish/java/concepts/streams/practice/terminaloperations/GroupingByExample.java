package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {

    public static void main(String[] args) {
        // Example of using groupingBy() in Java Streams
        System.out.println("GroupingBy Example:");

        // Example: Grouping a list of strings by their lengths
        // and collecting them into a map
        List<String> words = Arrays.asList("apple", "banana", "pear", "kiwi", "grape", "melon", "fig", "plum");

        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);

        // Example of groupingBy with counting
        Map<Integer, Long> countByLength = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(countByLength);

        // Example of groupingBy with summing lengths
        Map<Integer, Integer> sumByLength = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.summingInt(String::length)));

        System.out.println(sumByLength);

    }
}
