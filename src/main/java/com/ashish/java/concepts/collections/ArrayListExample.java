package com.ashish.java.concepts.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    static void main() {
        //create an ArrayList
        List<String> arrayList = new ArrayList<>();

        //add elements to the ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        // Access elements by index
        String firstElement = arrayList.get(0); // "Apple"
        String secondElement = arrayList.get(1); // "Banana"

        // Print the elements
        System.out.println("First Element: " + firstElement);
        System.out.println("Second Element: " + secondElement);

        System.out.println("----------------------------------------------------------------");
        //Iterate through the ArrayList
        for (String fruit : arrayList) {
            System.out.println(fruit); // Should print Apple, Banana, Cherry
        }

        System.out.println("----------------------------------------------------------------");

        // Remove an element
        arrayList.remove("Banana");
        for (String fruit : arrayList) {
            System.out.println(fruit); // Should print Apple and Cherry
        }

        // Get the size of the ArrayList
        int size = arrayList.size(); // size should be 2
        System.out.println("Size of ArrayList: " + size);
    }
}
