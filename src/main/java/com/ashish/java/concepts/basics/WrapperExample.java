package com.ashish.java.concepts.basics;

public class WrapperExample {

    static void main() {
        int num = 5;

        Integer obj = num;

        String str = obj.toString();

        int value = obj.intValue();
        System.out.println("primitive value: " + value);
    }
}
