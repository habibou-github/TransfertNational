package com.TransfertNational.demo.Shared;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public String generateStringId(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }



    public  String EncryptePassword(String password){
        try
        {
            // MessageDigest instance for MD5
            MessageDigest m = MessageDigest.getInstance("MD5");

            // Add plain-text password bytes to digest using MD5 update() method
            m.update(password.getBytes());

            // Convert the hash value into bytes
            byte[] bytes = m.digest();

            // The bytes array has bytes in decimal form. Converting it into hexadecimal format
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}