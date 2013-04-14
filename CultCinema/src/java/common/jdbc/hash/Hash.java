/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author A
 */
public class Hash {
    public static String encrypt(String hashType, String input) {
        String cipher = null;
        if(null == input) return null;
        
        try {
            MessageDigest digest = MessageDigest.getInstance(hashType);
            digest.update(input.getBytes(), 0, input.length());
            cipher = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return cipher;
    }

}
