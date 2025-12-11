package com.ashish.java.concepts.streams.practice.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExamples {

    public static void main(String[] args) throws IOException {
        // Stream.of
        List<String> s1 = Stream.of("a", "b", "c").toList();
        System.out.println("Stream.of: " + s1);

        //Arrays.stream
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> s2 = Arrays.stream(arr).boxed().toList();
        System.out.println("Arrays.stream: " + s2);

        //Collection.stream
        List<String> s3 = List.of("x", "y", "z").stream().toList();
        System.out.println("Collection.stream: " + s3);

        //Files.lines (ensure file exists)
        Path temp = Files.createTempFile("lines", ".txt");
        Files.writeString(temp, "Hello World");
        try (Stream<String> lines = Files.lines(temp)) {
            System.out.println("Files.lines: " + lines.count());
        } finally {
            Files.deleteIfExists(temp);
        }

        //Stream.generate
        List<Double> randoms = Stream.generate(Math::random).limit(5).toList();
        System.out.println("Stream.generate: " + randoms);

        //Stream.iterate
        List<Integer> evens = Stream.iterate(0, n -> n + 2).limit(5).toList();
        System.out.println("iterate evens: " + evens);

        //Stream.ofNullable
        String maybeNull = null;
        List<String> safe = Stream.ofNullable(maybeNull).toList();
        System.out.println("ofNullable size: " + safe.size());

        //concat
        List<String> concat = Stream.concat(Stream.of("A", "B"), Stream.of("C", "D")).toList();
        System.out.println("concat: " + concat);
    }
}
