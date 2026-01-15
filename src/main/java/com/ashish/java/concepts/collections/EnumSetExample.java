package com.ashish.java.concepts.collections;

import java.util.EnumSet;

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

public class EnumSetExample {
    static void main() {
        EnumSet<Day> weekends = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekends: " + weekends); // Output: Weekends: [SATURDAY, SUNDAY]

        EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Weekdays: " + weekdays); // Output: Weekdays: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]

        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays); // Output: All Days: [SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY]

    }

}
