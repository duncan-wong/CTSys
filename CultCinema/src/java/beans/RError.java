/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 52593578
 */
public class RError {
    private String errorCode;
    private String errorMessage;
    
    public RError(){
        errorCode = "";
        errorMessage = "Error";
    }
    
    public void setErrorCode(String errorCode){
        this.errorCode = errorCode;
        
        //set error message
        switch(Integer.valueOf(errorCode)){
            case 404:
                this.setErrorMessage("Page not found");
                break;
            case 403:
                this.setErrorMessage("Unauthorized access");
        }
    }
    
    public String getErrorCode(){
        return "ERROR " + this.errorCode;
    }
    
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
