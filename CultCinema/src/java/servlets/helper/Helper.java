
package servlets.helper;

import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUNCAN
 */
public class Helper {
    static public void addErrorMsgToRequest(HttpServletRequest request, String errorMsgLabel, String errorMsg){
        if (request.getAttribute("errorMsg") != null){
            ((Hashtable)request.getAttribute("errorMsg")).put(errorMsgLabel, errorMsg);
        }
        else{
            Hashtable<String, String> errorMsgContainer = new Hashtable<String, String>();
            errorMsgContainer.put(errorMsgLabel, errorMsg);
            request.setAttribute("errorMsg", errorMsgContainer);
        }
    }
    
    static public void addErrorMsgToSession(HttpServletRequest request, String errorMsgLabel, String errorMsg){
        HttpSession session = request.getSession();
        if (session.getAttribute("errorMsg") != null){
            ((Hashtable)session.getAttribute("errorMsg")).put(errorMsgLabel, errorMsg);
        }
        else{
            Hashtable<String, String> errorMsgContainer = new Hashtable<String, String>();
            errorMsgContainer.put(errorMsgLabel, errorMsg);
            session.setAttribute("errorMsg", errorMsgContainer);
        }
    }
    
    static public void clearErrorMsgInSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("errorMsg", null);
    }
}
