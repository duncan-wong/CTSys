/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.HashMap;


/**
 *
 * @author DUNCAN
 */
public class AUserMonitor {
    private HashMap<String, String> currentUserMointor;
    
    private AUserMonitor(){
        this.currentUserMointor = new HashMap<String, String>();
    }
}
