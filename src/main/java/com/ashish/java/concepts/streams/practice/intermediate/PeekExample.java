package com.ashish.java.concepts.streams.practice.intermediate;

import java.util.stream.IntStream;

public class PeekExample {

    public static void main(String[] args) {
        System.out.println("Peek Example:");
        System.out.println("---------------");

        // Using peek to log intermediate values in a stream
        int sum = IntStream.range(1, 10)
                .peek(n -> System.out.println("Original value: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("Squared value: " + n))
                .sum();

        System.out.println("Sum of squares: " + sum);
    }
}
