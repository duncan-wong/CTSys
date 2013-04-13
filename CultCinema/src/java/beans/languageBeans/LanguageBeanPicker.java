/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.languageBeans;

import beans.accessInterface.LanguageBean;
/**
 *
 * @author DUNCAN
 */
public class LanguageBeanPicker {
    private static String[] languageCode = {"en", "zh"};
    public static boolean isLanguageCodeExit(String code){
        boolean isExit = false;
        for (int i = 0; i < languageCode.length; i ++){
            if (languageCode[i].equalsIgnoreCase(code))
                return true;
        }
        return false;
    }
    
    //return the language bean according to code
    public static LanguageBean getLanguageBean(String code){
        if (code.equalsIgnoreCase(languageCode[0])){
            return new SLanguageB_en();
        }
        else if (code.equalsIgnoreCase(languageCode[1])){
            return new SLanguageB_zh();
        }
        
        return new SLanguageB_en();
    }
}
