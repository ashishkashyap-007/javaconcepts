package com.ashish.java.concepts.generics;

class NumberBox<T extends Number> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class BoundedParameterExample {
    static void main() {
        NumberBox<Integer> integerNumberBox = new NumberBox<>();
        integerNumberBox.setItem(1);
        System.out.println("Integer Value: " + integerNumberBox.getItem());

        NumberBox<Double> doubleNumberBox = new NumberBox<>();
        doubleNumberBox.setItem(1.0);
        System.out.println("Double Value: " + doubleNumberBox.getItem());

        // The following line would cause a compile-time error
        // NumberBox<String> stringNumberBox = new NumberBox<>(); // Error: String is not a subtype of Number

    }
}
