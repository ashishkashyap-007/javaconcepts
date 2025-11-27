package com.ashish.java.concepts.streams.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {
        // Example: Converting a list of strings to their uppercase equivalents using map
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upperCaseNames); // Output: [ALICE, BOB, CHARLIE]

        // Example: Squaring a list of integers using map
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squaredNums = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println(squaredNums); // Output: [1, 4, 9, 16, 25]

        // Example: Converting a list of strings to their lengths using map
        List<String> words = Arrays.asList("hello", "world", "java", "streams");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .toList();

        System.out.println(lengths); // Output: [5, 5, 4, 7]

        // Example: Prefixing each string in a list with "Item: " using map
        List<String> items = Arrays.asList("apple", "banana", "cherry");
        List<String> prefixedItems = items.stream()
                .map(item -> "Item: " + item)
                .toList();

        System.out.println(prefixedItems); // Output: [Item: apple, Item: banana, Item: cherry]

        // Example: Converting a list of temperatures in Celsius to Fahrenheit using map
        List<Double> celsiusTemps = Arrays.asList(0.0, 20.0, 37.0, 100.0);
        List<Double> fahrenheitTemps = celsiusTemps.stream()
                .map(c -> c * 1.8 + 32)
                .toList();

        System.out.println(fahrenheitTemps); // Output: [32.0, 68.0, 98.6, 212.0]


        // Example: Converting a list of full names to their first names using map
        List<String> fullNames = Arrays.asList("John Doe", "Jane Smith", "Emily Davis");
        List<String> firstNames = fullNames.stream()
                .map(name -> name.split(" ")[0])
                .toList();

        System.out.println(firstNames); // Output: [John, Jane, Emily]

    }
}
