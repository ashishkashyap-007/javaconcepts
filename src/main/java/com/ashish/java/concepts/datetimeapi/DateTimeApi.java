package com.ashish.java.concepts.datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {

    static void main() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        //Format date object using DateTimeFormatter
        System.out.println("------------------------------------------------");
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        System.out.println("Formatted Date: " + formattedDate);
    }
}
