/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 52593578
 */
public class SStatus {
    private boolean isLoggedIn;
    private String loginId;
    private String userName;
    private String languageOption;
    
    public SStatus(){
        isLoggedIn = false;
        loginId = common.RolesConfig.guestLoginId;
        userName = common.RolesConfig.guestUsername;
        languageOption = "en";
    }
    
    public void setIsLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
    
    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }
    
    public void setLoginId(String loginId){
        this.loginId = loginId;
    }
    
    public String getLoginId(){
        return this.loginId;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getuserName(){
        return this.userName;
    }
    
    public void setLanguageOption(String languageOption){
        this.languageOption = languageOption;
    } 
    
    public String getLanguageOption(){
        return this.languageOption;
    }
}
