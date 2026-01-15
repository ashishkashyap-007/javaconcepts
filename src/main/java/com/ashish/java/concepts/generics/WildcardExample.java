package com.ashish.java.concepts.generics;

import java.util.ArrayList;
import java.util.List;

class WildcardDemo {
    // Wildcard method to print elements of any type of list
    public void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // Wildcard method with upper bound
    public void printListMethodUpperBound(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    // Wildcard method with lower bound
    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }
}

public class WildcardExample {
    static void main() {
        WildcardDemo demo = new WildcardDemo();

        // Example usage of printList
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        System.out.println("Printing String List:");
        demo.printList(stringList);

        // Example usage of printListMethodUpperBound
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        System.out.println("Printing Double List (Upper Bound):");
        demo.printListMethodUpperBound(doubleList);

        // Example usage of addNumbers
        List<Number> numberList = new ArrayList<>();
        demo.addNumbers(numberList);
        System.out.println("Printing Number List after adding Integers (Lower Bound):");
        demo.printList(numberList);
    }
}
