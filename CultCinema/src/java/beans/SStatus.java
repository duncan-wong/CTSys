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
    private boolean isExclusivelyLoggedIn;
    private String loginId;
    private String userName;
    private String userRole;
    private String languageOption;
    private beans.SBooking currentBooking;
    
    public SStatus(){
        isLoggedIn = false;
        isExclusivelyLoggedIn = false;
        loginId = common.RolesConfig.guestLoginId;
        userName = common.RolesConfig.guestUsername;
        languageOption = "en";
        currentBooking = null;
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
    
    public void setUserRole(String userRole){
        this.userRole = userRole;
    }
    
    public String getUserRole(){
        return this.userRole;
    }
    
    public boolean getIsCustomer(){
        return common.RolesConfig.Member.equals(this.userRole);
    }
    
    public boolean getIsOfficer(){
        return common.RolesConfig.Officer.equals(this.userRole);
    }
    
    public void setLanguageOption(String languageOption){
        this.languageOption = languageOption;
    } 
    
    public String getLanguageOption(){
        return this.languageOption;
    }

    /**
     * @return the currentBooking
     */
    public beans.SBooking getCurrentBooking() {
        return currentBooking;
    }

    /**
     * @param currentBooking the currentBooking to set
     */
    public void setCurrentBooking(beans.SBooking currentBooking) {
        this.currentBooking = currentBooking;
    }

    /**
     * @return the isExclusivelyLoggedIn
     */
    public boolean getIsExclusivelyLoggedIn() {
        return isExclusivelyLoggedIn;
    }

    /**
     * @param isExclusivelyLoggedIn the isExclusivelyLoggedIn to set
     */
    public void setIsExclusivelyLoggedIn(boolean isExclusivelyLoggedIn) {
        this.isExclusivelyLoggedIn = isExclusivelyLoggedIn;
    }
    
    
}
