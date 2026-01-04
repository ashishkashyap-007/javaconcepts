package com.ashish.java.concepts.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    static void main() {
        // create a HashSet
        Set<String> hashSet = new HashSet<>();

        // add elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate, will not be added

        // Print the elements
        for (String fruit : hashSet) {
            System.out.println(fruit); // Should print Apple, Banana, Cherry (order not guaranteed)
        }
        System.out.println("--------------------------------------------------------------------");

        // Remove an element
        hashSet.remove("Banana");
        for (String fruit : hashSet) {
            System.out.println(fruit); // Should print Apple and Cherry
        }

        // Get the size of the HashSet
        int size = hashSet.size(); // size should be 2
        System.out.println("Size of HashSet: " + size);

        // Check if the HashSet contains an element
        boolean containsApple = hashSet.contains("Apple"); // should be true
        System.out.println("HashSet contains Apple? " + containsApple);

        // Clear the HashSet
        hashSet.clear();
        System.out.println("Size after clear: " + hashSet.size()); // size should be 0

        // Check if the HashSet is empty
        boolean isEmpty = hashSet.isEmpty(); // should be true
        System.out.println("Is HashSet empty? " + isEmpty);
    }
}
