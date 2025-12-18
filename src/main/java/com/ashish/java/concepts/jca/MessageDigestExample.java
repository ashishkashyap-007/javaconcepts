package com.ashish.java.concepts.jca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {

    static void main() throws NoSuchAlgorithmException {
        // Create a MessageDigest instance for SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        String input = "Hello, World!";
        byte[] inputBytes = input.getBytes();

        // Compute the hash
        messageDigest.update(inputBytes);

        // Get the resulting hash
        byte[] hash = messageDigest.digest();
        // Convert the hash to a hexadecimal string
        String hashHex = bytesToHex(hash);
        System.out.println("SHA-256 Hash: " + hashHex);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
