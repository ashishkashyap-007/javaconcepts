package com.ashish.java.concepts.streams.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortedExample {

    public static void main(String[] args) {
        // Example of sorting a stream of integers in reverse order
        System.out.println("Sorted Integers:");
        List<Integer> numbers = List.of(1, 5, 3, 10, 8, 4, 6, 7, 9, 2);

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // Example of sorting a stream of strings
        System.out.println("\nSorted Strings:");
        Stream.of("Banana", "Apple", "Orange", "Mango")
                .sorted()
                .forEach(System.out::println);

        // Example of sorting a list of Strings based on their length
        System.out.println("\nSorted Strings by Length:");
        List<String> fruits = List.of("Banana", "Apple", "Orange", "Mango", "Pineapple", "Kiwi");

        fruits.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);

        // Example of sorting a list of custom objects
        System.out.println("\nSorted Custom Objects by Age:");
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .forEach(System.out::println);

        // Example of sorting a list of custom objects by name
        System.out.println("\nSorted Custom Objects by Name:");
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        // Example of sorting a list of custom objects by multiple fields
        System.out.println("\nSorted Custom Objects by Name and Age:");
        List<Person> peopleWithDuplicates = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 25),
                new Person("Charlie", 35)
        );

        peopleWithDuplicates.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .forEach(System.out::println);

        //Example to sort the list of custom objects based on their name length in reverse order
        System.out.println("\nSorted Custom Objects by Name Length in Reverse Order:");
        people.stream()
                .sorted(Comparator.comparingInt((Person p) -> p.getName().length()).reversed())
                .forEach(System.out::println);


    }
}
