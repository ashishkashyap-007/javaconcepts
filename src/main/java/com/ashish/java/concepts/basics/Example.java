package com.ashish.java.concepts.basics;

public class Example {

    private int instanceVar;
    private static int staticVar;

    public void display() {
        int localVar = 10;
        System.out.println("Local variable: " + localVar);
    }

    static void main() {

        Example example = new Example();
        System.out.println("Instance variable: " + example.instanceVar);
        example.display();
        System.out.println("Static variable: " + staticVar);
    }
}
