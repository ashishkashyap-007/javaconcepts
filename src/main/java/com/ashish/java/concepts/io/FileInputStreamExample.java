package com.ashish.java.concepts.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    static void main() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\Ashish Kashyap\\OneDrive\\Desktop\\code\\InterviewPrep\\javaconcepts\\src\\main\\java\\com\\ashish\\java\\concepts\\io\\example.txt");

            int content;
            // Read until the end of the file is reached
            while ((content = fis.read()) != -1) {
                // convert the byte to char and display it
                System.out.print((char) content);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
