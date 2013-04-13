/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.languageBeans;

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
}
