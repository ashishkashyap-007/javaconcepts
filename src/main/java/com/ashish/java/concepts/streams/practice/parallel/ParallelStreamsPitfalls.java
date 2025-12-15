package com.ashish.java.concepts.streams.practice.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
        List<Integer> unsafe = new ArrayList<>();
        try {
            data.parallelStream().forEach(unsafe::add);
            System.out.println("\nunsafe list size: " + unsafe.size() + " (may be <20 or throw exception)");
        } catch (Exception e) {
            System.out.println("\nunsafe exception: " + e.getClass().getSimpleName());
        }

        // Safer alternative: thread-safe collector or data structure
        List<Integer> safe = new CopyOnWriteArrayList<>();
        data.parallelStream().forEach(safe::add);
        System.out.println("safe list size: " + safe.size() + " (should be 20)");

        // Cost vs benefit: small datasets often slower with parallel streams
        long startSeq = System.nanoTime();
        int seqSum = data.stream().mapToInt(Integer::intValue).sum();
        long endSeq = System.nanoTime();

        long startPar = System.nanoTime();
        int parSum = data.parallelStream().mapToInt(Integer::intValue).sum();
        long endPar = System.nanoTime();

        System.out.println("\nSequential sum: " + seqSum + " in " + (endSeq - startSeq) + " ns");
        System.out.println("Parallel sum: " + parSum + " in " + (endPar - startPar) + " ns");
    }
}
