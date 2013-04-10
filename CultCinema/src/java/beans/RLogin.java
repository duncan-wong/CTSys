/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author DUNCAN
 */
public class RLogin {
    private String errorMessage;
    
    public RLogin(){
        errorMessage = null;
    }
    
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
