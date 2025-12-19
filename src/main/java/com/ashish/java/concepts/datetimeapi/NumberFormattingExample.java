package com.ashish.java.concepts.datetimeapi;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormattingExample {
    static void main() {
        double number = 1234567.89;

        //Format Number for US Locale
        NumberFormat usFormatter = NumberFormat.getNumberInstance(Locale.US);
        String usNumber = usFormatter.format(number);
        System.out.println("US formatted number: " + usNumber);

        //Format Number for Germany Locale
        NumberFormat germanFormatter = NumberFormat.getNumberInstance(Locale.GERMANY);
        String germanNumber = germanFormatter.format(number);
        System.out.println("German formatted number: " + germanNumber);

        //Format Number for China Locale
        NumberFormat chinaFormatter = NumberFormat.getNumberInstance(Locale.CHINA);
        String chinaNumber = chinaFormatter.format(number);
        System.out.println("China formatted number: " + chinaNumber);
    }
}
