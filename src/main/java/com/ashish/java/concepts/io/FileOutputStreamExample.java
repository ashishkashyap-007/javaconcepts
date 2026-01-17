package com.ashish.java.concepts.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamExample {
    static void main() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\Ashish Kashyap\\OneDrive\\Desktop\\code\\InterviewPrep\\javaconcepts\\src\\main\\java\\com\\ashish\\java\\concepts\\io\\example.txt");

            String data = "writing to example.txt using FileOutputStream";
            // Convert String to byte array
            byte[] byteArray = data.getBytes(StandardCharsets.UTF_8);

            //write byte array to file
            fos.write(byteArray);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
