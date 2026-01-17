package com.ashish.java.concepts.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    static void main() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ashish Kashyap\\OneDrive\\Desktop\\code\\InterviewPrep\\javaconcepts\\src\\main\\java\\com\\ashish\\java\\concepts\\io\\largetextfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                //process the line
                System.out.println(line);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}
