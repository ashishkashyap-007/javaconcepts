package com.ashish.java.concepts.collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    static void main() {
        // create a TreeSet
        Set<String> treeSet = new TreeSet<>();

        // add elements to the TreeSet
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Cherry");
        treeSet.add("Apple"); // Duplicate, will not be added

        // Print the elements (will be in sorted order)
        for (String fruit : treeSet) {
            System.out.println(fruit); // Should print Apple, Banana, Cherry
        }

        System.out.println("--------------------------------------------------------------------");

        // Remove an element
        treeSet.remove("Banana");
        for (String fruit : treeSet) {
            System.out.println(fruit); // Should print Apple and Cherry
        }

        System.out.println("--------------------------------------------------------------------");

        // Get the size of the TreeSet
        int size = treeSet.size(); // size should be 2
        System.out.println("Size of TreeSet: " + size);

        // Check if the TreeSet contains an element
        boolean containsApple = treeSet.contains("Apple"); // should be true
        System.out.println("TreeSet contains Apple? " + containsApple);

        // Clear the TreeSet
        treeSet.clear();
        System.out.println("Size after clear: " + treeSet.size()); // size should be
    }
}
