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
    private String userId;
    private String userName;
    
    public SStatus(){
        isLoggedIn = false;
        userId = null;
        userName = null;
    }
    
    public void setIsLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
    
    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getUserId(){
        return this.userId;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getuserName(){
        return this.userName;
    }
}
