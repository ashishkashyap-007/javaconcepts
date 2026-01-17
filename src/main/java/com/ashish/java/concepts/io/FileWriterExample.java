package com.ashish.java.concepts.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    static void main() {
        FileWriter fw = null;

        try {
            fw = new FileWriter("C:\\Users\\Ashish Kashyap\\OneDrive\\Desktop\\code\\InterviewPrep\\javaconcepts\\src\\main\\java\\com\\ashish\\java\\concepts\\io\\example.txt");

            String data = "writing to example.txt using FileWriter";
            // Write data to file
            fw.write(data);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
