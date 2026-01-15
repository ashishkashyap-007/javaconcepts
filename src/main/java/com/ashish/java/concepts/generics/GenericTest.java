package com.ashish.java.concepts.generics;

import java.util.ArrayList;
import java.util.List;

class GenericList<T> {
    private List<T> elements = new ArrayList<>();

    public void add(T element) {
        this.elements.add(element);
    }

    public T get(int index) {
        return this.elements.get(index);
    }

}

public class GenericTest {
    static void main() {
        List<String> genericList = new ArrayList<>();
        genericList.add("Hello");
        genericList.add("World");

        System.out.println(genericList.get(0) + " " + genericList.get(1));
    }

}
