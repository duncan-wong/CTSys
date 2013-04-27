
package servlets.helper;

import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;

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
}
