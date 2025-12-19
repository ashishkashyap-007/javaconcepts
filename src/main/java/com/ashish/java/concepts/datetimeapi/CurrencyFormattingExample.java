package com.ashish.java.concepts.datetimeapi;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormattingExample {
    static void main() {
        double amount = 1234567.89;

        //Format currency for US locale
        NumberFormat usFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String usCurrency = usFormatter.format(amount);
        System.out.println("US Currency: " + usCurrency);

        //Format currency for UK locale
        NumberFormat ukFormatter = NumberFormat.getNumberInstance(Locale.UK);
        String ukCurrency = ukFormatter.format(amount);
        System.out.println("UK Currency: " + ukCurrency);

        //Format currency for Japan locale
        NumberFormat japanFormatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        String japanCurrency = japanFormatter.format(amount);
        System.out.println("Japan Currency: " + japanCurrency);
    }
}
