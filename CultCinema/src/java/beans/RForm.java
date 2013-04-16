/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author DUNCAN
 */
public class RForm {
    private int noOfField;
    private String[] fieldValue;
    private String[] fieldError;
    
    
    public RForm(){
        this.noOfField = 0;
    }
    
    public RForm(int noOfField){
        this.noOfField = noOfField;
        this.fieldValue = new String[this.noOfField];
        this.fieldError = new String[this.noOfField];
    }
    
    public void setFieldValue(int index, String fieldValue){
        if (index < this.noOfField && index >=0){
            this.fieldValue[index] = fieldValue;
        }
    }
    
    public String getFieldValue(int index){
        if (index < this.noOfField && index >=0){
            return this.fieldValue[index];
        }
        return null;
    }
    
    public void setFieldError(int index, String fieldError){
        if (index < this.noOfField && index >=0){
            this.fieldError[index] = fieldError;
        }
    }
    
    public String setfieldError(int index, String fieldError){
        if (index < this.noOfField && index >=0){
            return this.fieldError[index];
        }
        return null;
    }
}
