package com.ashish.java.concepts.streams.practice;

import java.util.Arrays;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class DistinctExample {

    public static void main(String[] args) {
        // Example of using distinct() to filter out duplicate values from a stream
        System.out.println("Distinct Example:");
        System.out.println("-----------------");

        int[] numbers = {1, 2, 2, 3, 4, 4, 5, 5, 5, 6};
        int[] array = Arrays.stream(numbers)
                .distinct()
                .toArray();

        System.out.println("Array with distinct values: " + Arrays.toString(array));

        // Example 2: Using distinct() with objects
        System.out.println("\nDistinct Objects Example:");
        System.out.println("-------------------------");

        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 30),
                new Person("Charlie", 35)
        };

        Arrays.stream(people)
                .distinct()
                .forEach(System.out::println);
    }
}
