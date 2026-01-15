package com.ashish.java.concepts.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Students {
    private String name;
    private int grade;
    private int studentId;

    public Students(String name, int grade, int studentId) {
        this.name = name;
        this.grade = grade;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", studentId=" + studentId +
                '}';
    }
}

class NameComparator implements Comparator<Students> {

    @Override
    public int compare(Students s1, Students s2) {
        return s1.getName().compareToIgnoreCase(s2.getName()); // Natural order
    }
}

class GradeComparator implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        return Integer.compare(o2.getGrade(), o1.getGrade()); // Descending order
    }
}


public class ComparatorExample {
    static void main() {
        List<Students> students = Arrays.asList(
                new Students("Alice", 85, 103),
                new Students("Bob", 90, 101),
                new Students("Charlie", 80, 102),
                new Students("Diana", 95, 104)
        );

        System.out.println("== original list ==");
        students.forEach(System.out::println);

        //Approach 1: Using separate Comparator classes
        System.out.println("== Sorted by Name (Ascending) ==");
        Collections.sort(students, new NameComparator());
        students.forEach(System.out::println);

        // Approach 2: Lambda Expression
        System.out.println("== Sorted by Grade (Descending) ==");
        students.sort((s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));
        students.forEach(System.out::println);

        // Approach 3: Method Reference with Comparator utility methods
        System.out.println("== Sorted by Student ID (Ascending) ==");
        students.sort(Comparator.comparing(Students::getStudentId));
        students.forEach(System.out::println);

        // Approach 4: Chaining comparators for complex sorting
        System.out.println("== Sorted by Grade (Descending) then Name (Ascending) ==");
        students.sort(Comparator.comparing(Students::getGrade).reversed()
                .thenComparing(Students::getName));
        students.forEach(System.out::println);

        // Approach 5: Anonymous class implementation
        System.out.println("== Sorted by Name Length (Ascending) ==");
        students.sort(new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        students.forEach(System.out::println);
    }
}
