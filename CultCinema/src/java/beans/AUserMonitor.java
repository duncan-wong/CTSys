/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpSession;


/**
 *
 * @author DUNCAN
 */
public class AUserMonitor {
    private static AUserMonitor aUserMonitor = null;
    private ConcurrentHashMap<String, String> currentUserMonitor;
    
    public static AUserMonitor getInstance(){
        if (aUserMonitor != null){
            return aUserMonitor;
        }
        return new AUserMonitor();
    }
    
    private AUserMonitor(){
        this.currentUserMonitor = new ConcurrentHashMap<String, String>();
    }
    
    public boolean userLogin(String userId, HttpSession session){
        if (this.currentUserMonitor.get(userId) != null){
            return false;
        }
        this.currentUserMonitor.put(userId, session.getId());
        return true;
    }
    
    public void userLoginExclusivly(String userId, HttpSession session){
        this.currentUserMonitor.put(userId, session.getId());
    }
    
    public boolean isSingleLogin(String userId, HttpSession session){
        if (session.getId().equals(this.currentUserMonitor.get(userId))){
            return false;
        }
        return true;
    }
}
