package com.ashish.java.concepts.streams.practice.prerequisites;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferencesExample {
    static class Person {
        final String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name) {
            this.name = name;
            this.age = 0;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        static int getNameLength(Person p) {
            return p.name.length();
        }
    }

    public static void main(String[] args) {
        // Static Method Reference
        Function<Person, Integer> nameLenStatic = Person::getNameLength;

        //Instance method reference of a particular object
        String prefix = "Mr. ";
        Function<String, String> addPrefix = prefix::concat;

        // Instance method ref of an arbitrary object of a particular type
        Function<String, String> toUpper = String::toUpperCase;

        // Constructor Method Reference
        Function<String, Person> person = Person::new;

        List<String> names = List.of("alice", "bob", "charlie");
        List<Person> people = names.stream().map(person).toList();
        System.out.println("People: " + people.stream().map(Person::getName).toList());
        System.out.println("Name lengths: " + people.stream().map(nameLenStatic).toList());
        System.out.println("Prefixed: " + names.stream().map(addPrefix).toList());
        System.out.println("Upper: " + names.stream().map(toUpper).toList());


        // Static Method Reference
        Function<Person, Integer> nameLengthFunc = MethodReferencesExample.Person::getNameLength;
        Person p1 = new Person("Alice", 30);
        System.out.println("Name Length (Static Method Ref): " + nameLengthFunc.apply(p1));

        // Instance Method Reference of a Particular Object
        Person p2 = new Person("Bob", 25);
        Supplier<String> nameSupplier = p2::getName;
        System.out.println("Name (Instance Method Ref of Particular Object): " + nameSupplier.get());

        // Instance Method Reference of an Arbitrary Object of a Particular Type
        Function<Person, String> getNameFunc = Person::getName;
        System.out.println("Name (Instance Method Ref of Arbitrary Object): " + getNameFunc.apply(p1));

        // Constructor Method Reference
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person p3 = personCreator.apply("Charlie", 28);
        System.out.println("Created Person (Constructor Method Ref): " + p3.getName() + ", Age: " + p3.getAge());
    }
}
