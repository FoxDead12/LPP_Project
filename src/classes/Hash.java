/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dx3
 */
public class Hash {
    
    public String generateHash (char[] password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(new String(password).getBytes("UTF-8"));
        String hashtext = convertToHex(messageDigest);

        return hashtext;
    }
    
    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
           hexText = "0".concat(hexText);
        }
        return hexText;
   }
}
