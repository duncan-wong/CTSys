/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUNCAN
 */
public class Validation {
    public static boolean isNull(Object obj){
        return (obj == null) || obj.equals("");
    }
    
    public static boolean isOnlyDigit(String str){
        for (int i = 0; i < str.length(); i ++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isConsistSpace(String str){
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == ' '){
                return true;
            }
        }
        return false;
    }
    
    
    public static boolean isPhone(String phone){
        if (isNull(phone)) return false;
        
        return isOnlyDigit(phone);
    }
    
    
    public static boolean isEmail(String email){
        if (isNull(email)) return false;
        
        if (!email.contains("@") || !email.contains(".")){
            return false;
        }
        
        if (email.contains("'") || email.contains(" ")){
            return false;
        }
        
        return true;
    }
    
    public static boolean isCreditCardNo(String no){
        if (isNull(no)) return false;
        
        if (!(isOnlyDigit(no) && no.length() == 16)){
            return false;
        }
        
        return true;
    }
    
    public static boolean isCreditCardSafeNo(String no){
        if (isNull(no)) return false;
        
        if (!(isOnlyDigit(no) && no.length() == 3)){
            return false;
        }
        
        return true;
    }
    
    public static boolean isCorrectDateString(String date) {
        try {
            // check the date string is valid
            // if invalid -> go ParseException
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
            df.setLenient(false);
            df.parse(date);
            return true;
            
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static boolean isCorrectTimeString(String time) {
        try {
            // check the date string is valid
            // if invalid -> go ParseException
            DateFormat df = new SimpleDateFormat("HH:mm");
            df.setLenient(false);
            df.parse(time);
            return true;
            
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static boolean isDateSmaller(String date1, String date2) {
        try {
            if (!isCorrectDateString(date1)
                && !isCorrectDateString(date2)) {
                return false;
            }
            
            // compare the date string
            Date d1 = new SimpleDateFormat("yyyy.MM.dd").parse(date1);
            Date d2 = new SimpleDateFormat("yyyy.MM.dd").parse(date2);
            
            if (d1.before(d2))
                return true;
            else
                return false;
            
        } catch (ParseException ex) {
            return false;
        }
    }
}
