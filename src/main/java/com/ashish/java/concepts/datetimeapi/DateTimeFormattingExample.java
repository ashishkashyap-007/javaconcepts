package com.ashish.java.concepts.datetimeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormattingExample {
    static void main() {
        LocalDate date = LocalDate.now();

        //Format date for US locale
        DateTimeFormatter usFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        String usDate = date.format(usFormatter);
        System.out.println("US Formatted Date: " + usDate);

        //Format date for France locale
        DateTimeFormatter franceFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE);
        String franceDate = date.format(franceFormatter);
        System.out.println("France Formatted Date: " + franceDate);

        //Format date for Japan locale
        DateTimeFormatter japanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.JAPAN);
        String japanDate = date.format(japanFormatter);
        System.out.println("Japan Formatted Date: " + japanDate);

    }
}
