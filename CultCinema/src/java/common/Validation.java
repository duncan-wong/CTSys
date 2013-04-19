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
        return (obj == null) || obj.equals("");
    }
    
    public static boolean isConsistSpace(String str){
        if (isNull(str)) return false;
        
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == ' '){
                return true;
            }
        }
        return false;
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
