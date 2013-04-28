/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author DUNCAN
 */
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        //clear up booking
        servlets.orderTicketHelper.BookingHandler.clearSessionCurrentBooking(se.getSession());
        
        //logout in AUserMonitor
        beans.SStatus sStatus = (beans.SStatus) se.getSession().getAttribute(common.BeansConfig.sStatus);
        beans.AUserMonitor aUserMonitor = beans.AUserMonitor.getInstance();
        aUserMonitor.userLogout(sStatus.getLoginId(), se.getSession());
    }
}
