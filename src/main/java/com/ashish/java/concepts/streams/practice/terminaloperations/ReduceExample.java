package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.Arrays;

public class ReduceExample {

    public static void main(String[] args) {
        // Example: Summing a list of integers using reduce
        int[] numbers = {1, 2, 3, 4, 5};

        int reduced = Arrays.stream(numbers)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + reduced); // Output: Sum: 15

        // Example: Finding the maximum value in a list of integers using reduce
        int max = Arrays.stream(numbers)
                .reduce(0, (a, b) -> a > b ? a : b);

        System.out.println("Max: " + max); // Output: Max: 5

        // Example: Concatenating a list of strings using reduce
        String[] words = {"Hello", " ", "World", "!" };

        String concatenated = Arrays.stream(words)
                .reduce("", (a, b) -> a + b);

        System.out.println("Concatenated String: " + concatenated); // Output: Concatenated String: Hello World!

        // Example: Calculating the product of a list of integers using reduce
        int product = Arrays.stream(numbers)
                .reduce(1, (a, b) -> a * b);

        System.out.println("Product: " + product); // Output: Product: 120
    }
}
