package com.ashish.java.concepts.basics;

public class StringExamples {

    public static void main(String[] args) {
        String reversed_string = new StringBuilder("Hello World!").reverse().toString();
        System.out.println(reversed_string);

        String formattedString = String.format("Hello %s Welcome to java basics have %s!", "Ashish", "fun");
        System.out.println(formattedString);
    }
}
