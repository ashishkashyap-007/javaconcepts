package com.ashish.java.concepts.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherExample {
    static void main() {
        String regex = "\\d+";
        String input = "789abc123def456";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean result = matcher.matches();
        System.out.println("Matches() : " + result);

        matcher.reset();
        while (matcher.find()) {
            System.out.println("Found : " + matcher.group() + " starting at " + matcher.start() + " and ending at " + matcher.end());
        }

        matcher.reset();
        if (matcher.lookingAt()) {
            System.out.println("LookingAt() : " + matcher.group());
        } else {
            System.out.println("LookingAt() : No match found");
        }
    }
}
