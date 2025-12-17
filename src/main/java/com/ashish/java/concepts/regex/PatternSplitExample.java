package com.ashish.java.concepts.regex;

import java.util.regex.Pattern;

public class PatternSplitExample {

    static void main() {
        String regex = "\\s+";
        String input = "This   is  a   sample   string";

        Pattern pattern = Pattern.compile(regex);
        String[] result = pattern.split(input);

        for (String part : result) {
            System.out.println(part);
        }
    }
}
