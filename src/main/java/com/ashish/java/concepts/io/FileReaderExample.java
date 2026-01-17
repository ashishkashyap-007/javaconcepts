package com.ashish.java.concepts.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    static void main() {
        try (FileReader fr = new FileReader("C:\\Users\\Ashish Kashyap\\OneDrive\\Desktop\\code\\InterviewPrep\\javaconcepts\\src\\main\\java\\com\\ashish\\java\\concepts\\io\\largetextfile.txt")) {
            int character;
            while ((character = fr.read()) != -1) {
                //process the character
                System.out.print((char) character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
