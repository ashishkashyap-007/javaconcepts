package com.ashish.java.concepts.datetimeapi;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationExample {
    public static void main(String[] args) {
        Locale locale = Locale.of("de", "DE");
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        String greeting = messages.getString("greeting");
        String farewell = messages.getString("farewell");

        System.out.println("Greeting: " + greeting);
        System.out.println("Farewell: " + farewell);
    }
}
