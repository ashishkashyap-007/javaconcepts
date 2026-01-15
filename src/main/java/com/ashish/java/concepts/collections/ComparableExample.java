package com.ashish.java.concepts.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int grade;
    private int studentId;

    public Student(String name, int grade, int studentId) {
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
    public int compareTo(Student otherStudent) {
        return Integer.compare(this.studentId, otherStudent.studentId);
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

public class ComparableExample {
    static void main() {
        List<Student> students = Arrays.asList(
                new Student("Alice", 90, 3),
                new Student("Bob", 85, 1),
                new Student("Charlie", 92, 2)
        );

        Collections.sort(students); // Sorts based on studentId

        students.forEach(System.out::println);

    }
}
