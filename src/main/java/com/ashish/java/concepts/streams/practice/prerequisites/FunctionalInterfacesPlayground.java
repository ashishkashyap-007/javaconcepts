package com.ashish.java.concepts.streams.practice.prerequisites;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfacesPlayground {

    public static void main(String[] args) {
        // Predicate: filter + composition
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> evenAndPositive = isEven.and(isPositive);

        List<Integer> nums = List.of(-3, -2, -1, 0, 1, 2, 3, 4);
        List<Integer> filtered = nums.stream()
                .filter(evenAndPositive.or(n -> n == 0))
                .toList();

        System.out.println("Predicate - Filtered List: " + filtered);

        // Function: transform + compose
        Function<Integer, Integer> square = n -> n * n;
        Function<Integer, String> toStr = Object::toString;
        Function<Integer, String> squareThenToStr = square.andThen(toStr);
        System.out.println("Function composed result: " + squareThenToStr.apply(5));

        // UnaryOperator/BinaryOperator
        UnaryOperator<String> trimAndUpper = str -> str.trim().toUpperCase();
        System.out.println("UnaryOperator result: '" + trimAndUpper.apply("   hello world   ") + "'");
        BinaryOperator<Integer> add = Integer::sum;
        System.out.println("BinaryOperator result: " + add.apply(10, 20));

        //Supplier: lazy evaluation
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Supplier result: " + randomSupplier.get());

        // Consumer/BiConsumer: side-effect printing
        Consumer<String> printer = System.out::println;
        printer.accept("Consumer printing this line!");
        BiConsumer<String, Integer> labelValuePrinter = (l, v) -> System.out.println(l + ": " + v);
        labelValuePrinter.accept("Age", 30);

        //Comparator: custom sorting
        Comparator<String> byLengthThenLex = Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder());
        List<String> words = List.of("apple", "banana", "pear", "kiwi", "grape", "fig");
        List<String> sortedList = words.stream().sorted(byLengthThenLex).toList();
        System.out.println("Comparator sorted: " + sortedList);

        //BiFunction: combining two inputs
        BiFunction<Integer, Integer, String> combine = (a, b) -> "Combined: " + (a + b);
        System.out.println(combine.apply(5, 10));

    }
}
