package com.ashish.java.concepts.streams.practice.intermediate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
        // Example: Flattening a list of lists using flatMap
        var listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );

        var flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Example: Flattening a list of strings into characters using flatMap
        List<String> words = List.of("Hello", "World");

        List<Character> characterList = words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .toList();

        System.out.println(characterList); // Output: [H, e, l, l, o, W, o, r, l, d]

        // Example: Flattening a list of sentences into words using flatMap
        List<String> sentences = List.of(
                "Java is fun",
                "Streams are powerful",
                "FlatMap is useful"
        );

        List<String> allWords = sentences.stream()
                .flatMap(sentence -> Stream.of(sentence.split(" ")))
                .toList();

        System.out.println(allWords); // Output: [Java, is, fun, Streams, are, powerful, FlatMap, is, useful]
    }
}
