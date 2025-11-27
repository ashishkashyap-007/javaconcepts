package com.ashish.java.concepts.streams.practice;

import java.util.Arrays;

public class FilterExample {
    //Filter Example to print even numbers from an array
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // Example 2: Filter names starting with 'A'
        String[] names = {"Ashish", "Bob", "Alice", "Charlie", "Anita" };
        Arrays.stream(names)
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);

        // Example 3: Filter numbers greater than 5
        Arrays.stream(numbers)
                .filter(n -> n > 5)
                .forEach(System.out::println);

        // Example 4: Filter strings with length greater than 3
        String[] words = {"Java", "is", "fun", "stream", "API" };
        Arrays.stream(words)
                .filter(n -> n.length() > 3)
                .forEach(System.out::println);


        // Example 5: Filter out null and empty strings from an array
        String[] data = {"Java", "", null, "Streams", " ", "API", null, "Filter" };
        Arrays.stream(data)
                .filter(n -> n != null && !n.trim().isEmpty())
                .forEach(System.out::println);
    }
}
