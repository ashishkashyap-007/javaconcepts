package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByExample {

    public static void main(String[] args) {
        // Example of using partitioningBy() in Java Streams
        System.out.println("PartitioningBy Example:");

        // Example: Partitioning a list of integers into even and odd numbers
        // and collecting them into a map
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitionedByEvenOdd = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitionedByEvenOdd);

        // Example: Partitioning a list of integers into even and odd numbers
        // and collecting them into a map with custom defined keys
        Map<String, List<Integer>> customPartitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0,
                        Collectors.mapping(n -> n, Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() ? "Even" : "Odd",
                        Map.Entry::getValue
                ));


        //alternatively you can do this way also
        Map<String, List<Integer>> customPartitionedMap = numbers.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.partitioningBy(n -> n % 2 == 0),
                        partition -> {
                            Map<String, List<Integer>> result = new HashMap<>();
                            result.put("Even", partition.get(true));
                            result.put("Odd", partition.get(false));
                            return result;
                        }
                ));

        System.out.println(customPartitioned);
        System.out.println(customPartitionedMap);
    }
}
