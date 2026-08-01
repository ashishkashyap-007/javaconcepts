package com.ashish.java.concepts.basics;

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumExample {

    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.FRIDAY;

        switch (day) {
            case MONDAY -> System.out.println("Today is Monday");
            case TUESDAY -> System.out.println("Today is Tuesday");
            case WEDNESDAY -> System.out.println("Today is Wednesday");
            case THURSDAY -> System.out.println("Today is Thursday");
            case FRIDAY -> System.out.println("Today is Friday");
            case SATURDAY -> System.out.println("Today is Saturday");
            case SUNDAY -> System.out.println("Today is Sunday");
        }

        System.out.println("Today is: " + day);

        for (DayOfWeek dow : DayOfWeek.values()) {
            System.out.println(dow);
        }
    }
}
