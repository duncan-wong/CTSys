/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accessInterface;

/**
 *
 * @author DUNCAN
 */
public abstract class UpdatableBean extends Bean {
    //modify the primary content
    private boolean isChanged;
    //newly created without fetchDBData
    private boolean isNew;
    
    public UpdatableBean(){
        this.isChanged = false;
        this.isNew = true;
    }
    
    //check if the bean is new
    public boolean isNew(){
        return this.isNew;
    }
    
    //check if any content is changed
    public boolean isChanged(){
        return this.isChanged;
    };
    
    //reset isChange to false when fetchDBData
    public boolean fetchDBData(){
        this.isNew = false;
        this.isChanged = false;
        return true;
    }
    
    //set isChanged = true
    protected void setChangedTrue(){
        this.isChanged = true;
    }
    
    //set isNew = false
    protected void setNewFalse(){
        this.isNew = false;
    }
    
    //push data back to DB
    public boolean commitChange(){
        this.isChanged = false;
        return true;
    };
}
