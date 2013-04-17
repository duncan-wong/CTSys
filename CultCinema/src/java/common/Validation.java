/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DUNCAN
 */
public class Validation {
    public static boolean isNull(Object obj){
        return (obj == null);
    }
    
    public static boolean isPhone(String phone){
        if (isNull(phone)) return false;
        
        for (int i = 0; i < phone.length(); i ++){
            if (!Character.isDigit(phone.charAt(i))){
                return false;
            }
        }
        return true;
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
}
