package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveAndStatisticsExample {

    static void main() {
        IntSummaryStatistics stats = IntStream.of(3, 5, 7, 2, 9).summaryStatistics();
        System.out.println("count=" + stats.getCount() + ", sum=" + stats.getSum()
                + ", min=" + stats.getMin() + ", max=" + stats.getMax()
                + ", avg=" + stats.getAverage());

        int sum = IntStream.rangeClosed(1, 5).sum();
        OptionalDouble average = IntStream.rangeClosed(1, 5).average();
        System.out.println("sum: " + sum + ", average: " + (average.isPresent() ? average.getAsDouble() : "N/A"));

        int totalLength = Stream.of("a", "bb", "ccc").mapToInt(String::length).sum();
        System.out.println("total length of strings: " + totalLength);

        // Edge case: average on empty stream
        System.out.println("average on empty: " + IntStream.empty().average().orElse(Double.NaN));

    }
}
