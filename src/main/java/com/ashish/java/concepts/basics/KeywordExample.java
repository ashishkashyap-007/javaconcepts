package com.ashish.java.concepts.basics;

class StaticExample {

    static int staticVariable = 10;

    static void staticMethod() {
        System.out.println("Inside static method: staticVariable = " + staticVariable);
    }
}

abstract class AbstractExample {
    abstract void abstractMethod();
}

class ConcreteExample extends AbstractExample {

    @Override
    void abstractMethod() {
        System.out.println("Inside abstractMethod in ConcreteExample");
    }
}

class FinalExample {
    final int finalVariable = 10;

    final void finalMethod() {
        System.out.println("Inside finalMethod in FinalExample finalVariable = " + finalVariable);
    }
}

public class KeywordExample {
    public static void main(String[] args) {
        // Accessing static variable and method using class names
        System.out.println("Static variable: " + StaticExample.staticVariable);
        StaticExample.staticMethod();

        // Creating an instance of ConcreteExample and calling the abstract method
        ConcreteExample concreteExample = new ConcreteExample();
        concreteExample.abstractMethod();

        // Creating an instance of FinalExample and accessing final variable and method
        FinalExample finalExample = new FinalExample();
        System.out.println("Final variable: " + finalExample.finalVariable);
        finalExample.finalMethod();
    }
}


