package com.ashish.java.concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodExample {

    // Generic method to convert and array to a list
    public static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    static void main() {
        // Example with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> integers = arrayToList(intArray);
        System.out.println("Integer List: " + integers);

        // Example with String array
        String[] stringArray = {"Apple", "Banana"};
        List<String> strings = arrayToList(stringArray);
        System.out.println("String List: " + strings);
    }
}
