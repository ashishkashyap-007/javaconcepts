package com.ashish.java.concepts.streams.practice.primitive;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamsExample {

    public static void main(String[] args) {
        // IntStream starts
        IntSummaryStatistics stats = IntStream.of(3, 1, 4, 1, 5, 9).summaryStatistics();
        System.out.println("Int stats: " + stats);

        //sum/average
        long sum = LongStream.rangeClosed(1, 10).sum();
        DoubleStream.of(1.0, 2.0, 3.0).average().ifPresent(avg -> System.out.println("Average: " + avg));
        System.out.println("Sum of 1 to 10: " + sum);

        //Boxing and unboxing
        List<Integer> boxed = IntStream.range(0, 5).boxed().toList();
        int[] array = boxed.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Boxed: " + boxed + ", toArray length: " + array.length);
    }
}
