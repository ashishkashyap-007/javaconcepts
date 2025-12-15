package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxCountExample {
    static void main() {
        List<String> words = List.of("alpha", "beta", "gamma", "delta", "epsilon");

        long count = words.stream().count();
        Optional<String> minByLength = words.stream().min(Comparator.comparingInt(String::length));
        Optional<String> maxLex = words.stream().max(Comparator.naturalOrder());

        System.out.println("count: " + count);
        System.out.println("min by length: " + minByLength.orElse("N/A"));
        System.out.println("max (lexicographic): " + maxLex.orElse("N/A"));

        // Edge case: empty stream with fallback
        List<String> empty = List.of();
        String minOnEmpty = empty.stream().min(Comparator.naturalOrder()).orElse("N/A");
        System.out.println("min on empty: " + minOnEmpty);
    }
}
