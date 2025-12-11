package com.ashish.java.concepts.streams.practice.parallel;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamsPitfalls {

    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 20).boxed().toList();

        // Non-deterministic order with parallel forEach
        System.out.println("Parallel forEach (non-deterministic order):");
        data.parallelStream().forEach(System.out::println);

        //Deterministic order with parallel forEachOrdered
        System.out.println("\nParallel forEachOrdered (deterministic order):");
        data.parallelStream().forEachOrdered(System.out::println);

        //Side-effects: unsafe mutation (race conditions)

    }
}
