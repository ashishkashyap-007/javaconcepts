package com.ashish.java.concepts.jca;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SymmetricEncryptionExample {

    static void main() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        // Generate a symmetric key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        String message = "This is a secret message";

        // Encrypt the message
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        System.out.println("Encrypted: " + new String(encryptedBytes));

        //Decrypt the message
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encryptedBytes);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
