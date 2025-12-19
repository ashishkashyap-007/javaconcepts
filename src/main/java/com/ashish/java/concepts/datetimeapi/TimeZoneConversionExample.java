package com.ashish.java.concepts.datetimeapi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConversionExample {

    static void main() {
        ZoneId londonZone = ZoneId.of("Europe/London");
        System.out.println("Zone ID: " + londonZone);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime londonDateTime = localDateTime.atZone(londonZone);
        System.out.println("Current Date and Time in Los Angeles: " + londonDateTime);

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = londonDateTime.withZoneSameInstant(newYorkZone);
        System.out.println("Converted Date and Time in New York: " + newYorkTime);


    }
}
