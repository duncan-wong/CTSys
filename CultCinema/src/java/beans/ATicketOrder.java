/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.*;
/**
 *
 * @author DUNCAN
 */
public class ATicketOrder implements Bean {
    
    //Use hashtable to store new ticket order [a Ticket Order request bean]
    //Ticket order bean contains the order info, payment status, expire date
    //Use synchronized block to check, put, remove entries in the hashtable
    
    //fetch data of the bean from DB
    public boolean fetchDBData(){return true;}
    
    //push data back to DB
    public boolean commitChange(){return true;}
    
}
