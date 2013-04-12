/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accessInterface;

/**
 *
 * @author DUNCAN
 */
public interface bean {
    //fetch data of the bean from DB
    public abstract void fetchDBData();
    
    //push data back to DB
    public abstract void commitChange();
}
