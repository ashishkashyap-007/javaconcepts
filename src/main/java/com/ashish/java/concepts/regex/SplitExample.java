package com.ashish.java.concepts.regex;

public class SplitExample {

    static void main() {
        String input = "apple,banana,cherry,orange,grape";
        String regex = ",";

        String[] fruits = input.split(regex);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
