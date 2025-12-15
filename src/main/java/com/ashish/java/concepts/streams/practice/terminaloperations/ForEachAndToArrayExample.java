package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForEachAndToArrayExample {

    static void main() {
        List<Integer> data = IntStream.rangeClosed(1, 8).boxed().collect(Collectors.toList());

        System.out.print("parallel forEach: ");
        data.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.print("parallel forEachOrdered: ");
        data.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();

        Object[] objs = Stream.of("a", "bb", "ccc").toArray();
        String[] arr = Stream.of("a", "bb", "ccc").toArray(String[]::new);
        System.out.println("toArray (Object[]): " + Arrays.toString(objs));
        System.out.println("toArray (String[]): " + Arrays.toString(arr));

    }
}
