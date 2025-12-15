package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningAndToListExample {

    static void main() {
        List<String> words = List.of("alpha", "beta", "gamma");

        String joined = words.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joining: " + joined);

        List<String> unmodifiable = Stream.of("x", "y").toList(); // Java 16+
        System.out.println("toList (unmodifiable): " + unmodifiable);
        try {
            unmodifiable.add("z"); // throws
        } catch (UnsupportedOperationException ex) {
            System.out.println("toList add -> UnsupportedOperationException");
        }

        List<String> modifiable = Stream.of("x", "y").collect(Collectors.toList());
        modifiable.add("z");
        System.out.println("Collectors.toList (modifiable): " + modifiable);

    }
}
