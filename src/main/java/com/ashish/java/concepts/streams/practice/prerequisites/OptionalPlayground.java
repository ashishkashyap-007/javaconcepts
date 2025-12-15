package com.ashish.java.concepts.streams.practice.prerequisites;

import java.util.Optional;

public class OptionalPlayground {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Ashish");
        Optional<String> empty = Optional.empty();
        Optional<String> nullable = Optional.ofNullable(null);

        //map/flatmap
        String upper = name.map(String::toUpperCase).orElse("UNKNOWN");
        System.out.println("Uppercase name: " + upper);

        //flatmap to derive optional length for non-empty
        Optional<Integer> nameLength = name.flatMap(n -> n.isEmpty() ? Optional.empty() : Optional.of(n.length()));
        System.out.println("Length present: " + nameLength.isPresent());

        //Defaults
        System.out.println("Name or default: " + empty.orElse("DefaultName"));
        System.out.println("Nullable default supplier: " + nullable.orElseGet(() -> "GeneratedName"));

        //guarded operations
        name.filter(n -> n.startsWith("A")).ifPresent(n -> System.out.println("Name starts with A: " + n));

        //orElseThrow
        try {
            empty.orElseThrow(() -> new IllegalArgumentException("No value present"));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
