package com.ashish.java.concepts.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    static void main() {
        String regex = "\\bcat\\b";
        Pattern pattern = Pattern.compile(regex);

        String input = "The cat sat on the mat.";
        Matcher matcher = pattern.matcher(input);

        boolean found = matcher.find();

        if (found) {
            System.out.println("Match found: " + matcher.group());
        } else {
            System.out.println("No match found.");
        }

        matcher.reset();
        while (matcher.find()) {
            System.out.println("Match: " + matcher.group() + " at positions " + matcher.start() + "-" + (matcher.end() - 1));
        }

    }
}
