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
        return aUserMonitor = new AUserMonitor();
    }
    
    private AUserMonitor(){
        this.currentUserMonitor = new ConcurrentHashMap<String, String>();
    }
    
    public boolean userLogin(String loginId, HttpSession session){
        if (this.currentUserMonitor.get(loginId) != null){
            return false;
        }
        this.currentUserMonitor.put(loginId, session.getId());
        return true;
    }
    
    public void userLogout(String loginId, HttpSession session){
        if (session.getId().equals(this.currentUserMonitor.get(loginId))){
            this.currentUserMonitor.remove(loginId);
        }
    }
    
    public void userLoginExclusivly(String loginId, HttpSession session){
        this.currentUserMonitor.put(loginId, session.getId());
    }
    
    public boolean isSingleLogin(String loginId, HttpSession session){
        if (this.currentUserMonitor.get(loginId) != null
            &&!session.getId().equals(this.currentUserMonitor.get(loginId))){
            return false;
        }
        return true;
    }
}
