package com.ashish.java.concepts.collections;

import java.util.LinkedList;

public class LinkedListExample {

    static void main() {
        //create a LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        // add elements to the LinkedList
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        // Access elements by index
        Integer firstElement = linkedList.get(0); // 10
        Integer secondElement = linkedList.get(1); // 20

        // Print the elements
        System.out.println("First Element: " + firstElement);
        System.out.println("Second Element: " + secondElement);

        System.out.println("----------------------------------------------------------------");

        // Iterate through the LinkedList
        for (Integer number : linkedList) {
            System.out.println(number); // Should print 10, 20, 30
        }

        System.out.println("----------------------------------------------------------------");
        // Remove an element
        linkedList.remove(Integer.valueOf(20));
        for (Integer number : linkedList) {
            System.out.println(number); // Should print 10 and 30
        }

        // Get the size of the LinkedList
        int size = linkedList.size(); // size should be 2
        System.out.println("Size of LinkedList: " + size);

        // Add elements at beginning and end
        linkedList.addFirst(0);
        linkedList.addLast(50);

        System.out.println("----------------------------------------------------------------");
        for (Integer number : linkedList) {
            System.out.println(number); // Should print 0, 10, 30, 50
        }

        System.out.println("----------------------------------------------------------------");
        // Get first and last elements
        Integer first = linkedList.getFirst(); // 0
        Integer last = linkedList.getLast();   // 50
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);

        // Clear the LinkedList
        linkedList.clear();
        System.out.println("Size after clear: " + linkedList.size()); // size should be 0

        // Check if the LinkedList is empty
        boolean isEmpty = linkedList.isEmpty(); // should be true
        System.out.println("Is LinkedList empty? " + isEmpty);
    }
}
