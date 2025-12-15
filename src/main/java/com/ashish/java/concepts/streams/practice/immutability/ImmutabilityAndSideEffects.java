package com.ashish.java.concepts.streams.practice.immutability;

import java.util.ArrayList;
import java.util.List;

public class ImmutabilityAndSideEffects {

    static void main() {
        //Immutable source
        List<String> source = List.of("a", "bb", "ccc");

        //pure mapping (no external state modified)
        List<Integer> lengths = source.stream().map(String::length).toList();
        System.out.println("Pure result: " + lengths);

        //Side effect with peek (for debugging only)
        List<String> upper = source.stream()
                .peek(s -> System.out.println("peek: " + s))
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase result: " + upper);

        //Anti-pattern: mutating external list inside stream
        List<String> trap = new ArrayList<>();
        source.stream().forEach(trap::add); //works but mixes computation with mutation
        System.out.println("External mutation size: " + trap.size());

        //prefer collect to create new immutable list
        List<String> copied = source.stream().toList();
        try {
            copied.add("x");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify copied list: " + e.getClass().getSimpleName());
        }
    }

}
