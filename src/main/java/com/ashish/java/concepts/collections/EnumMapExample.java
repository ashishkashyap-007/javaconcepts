package com.ashish.java.concepts.collections;

import java.util.EnumMap;

enum Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

public class EnumMapExample {
    static void main() {
        EnumMap<Days, String> activityMap = new EnumMap<>(Days.class);
        activityMap.put(Days.MONDAY, "Go to Gym");
        activityMap.put(Days.WEDNESDAY, "Attend Meeting");
        activityMap.put(Days.FRIDAY, "Movie Night");

        for (Days day : Days.values()) {
            System.out.println(day + ": " + activityMap.getOrDefault(day, "No Activity Scheduled"));
        }
    }
    /*
    Output:
    MONDAY: Go to Gym
    TUESDAY: No Activity Scheduled
    WEDNESDAY: Attend Meeting
    THURSDAY: No Activity Scheduled
    FRIDAY: Movie Night
    SATURDAY: No Activity Scheduled
    SUNDAY: No Activity Scheduled
     */
}
