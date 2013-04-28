package servlets.officer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUNCAN
 */
public class Officer_Checkout extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        boolean isSuccess = true;
        beans.accessInterface.LanguageBean lb = beans.languageBeans.LanguageBeanPicker.getLanguageBean(((beans.SStatus)session.getAttribute(common.BeansConfig.sStatus)).getLanguageOption());
        if (session.getAttribute(common.URLConfig.isFrom(common.URLConfig.SURLo_checkout)) != null){
            //reset
            session.setAttribute(common.URLConfig.isFrom(common.URLConfig.SURLo_checkout), null);
            
            //operation on single item
            if (!common.Validation.isNull(request.getParameter("bid"))){
                beans.RBooking booking = new beans.RBooking(request.getParameter("bid"));
                if (booking != null){
                    if (request.getServletPath().equals(common.URLConfig.SURLo_checkoutPay)){
                        if (!servlets.orderTicketHelper.BookingHandler.makePayment(session, booking, beans.accessInterface.BookingPaymentStatus.Payment_Complete)){
                            isSuccess = false;
                        }
                    }
                    else if(request.getServletPath().equals(common.URLConfig.SURLo_checkoutCancel)){
                        if (!servlets.orderTicketHelper.BookingHandler.deleteBooking(booking)){
                            isSuccess = false;
                        }
                    }
                }
                if (isSuccess){
                    if (request.getServletPath().equals(common.URLConfig.SURLo_checkoutPay)){
                        request.setAttribute("paymentMsg", lb.pMsgPayOne());
                    }
                    else{
                        request.setAttribute("paymentMsg", lb.pMsgCancelOne());
                    }
                }
            }
            //operation on all items
            else if (!request.getServletPath().equals(common.URLConfig.SURLo_checkout)){
                beans.RBookingCol bookingCol = new beans.RBookingCol();
                bookingCol.searchPaymentStatus(beans.accessInterface.BookingPaymentStatus.Payment_Deferred);
                bookingCol.fetchDBData();
                for (int i = 0; i < bookingCol.getCount(); i++){
                    if (bookingCol.getAt(i) != null){
                        if (request.getServletPath().equals(common.URLConfig.SURLo_checkoutPay)){
                            if (!servlets.orderTicketHelper.BookingHandler.makePayment(session, bookingCol.getAt(i), beans.accessInterface.BookingPaymentStatus.Payment_Complete)){
                                isSuccess = false;
                            }
                        }
                        else if(request.getServletPath().equals(common.URLConfig.SURLo_checkoutCancel)){
                            if(!servlets.orderTicketHelper.BookingHandler.deleteBooking(bookingCol.getAt(i))){
                                isSuccess = false;
                            }
                        }
                    }
                }
                if (isSuccess){
                    if (request.getServletPath().equals(common.URLConfig.SURLo_checkoutPay)){
                        request.setAttribute("paymentMsg", lb.pMsgPayAll());
                    }
                    else{
                        request.setAttribute("paymentMsg", lb.pMsgCancelAll());
                    }
                }
            }
        }
        
        
        beans.RBookingCol rBookingCol = new beans.RBookingCol();
        rBookingCol.searchPaymentStatus(beans.accessInterface.BookingPaymentStatus.Payment_Deferred);
        rBookingCol.fetchDBData();
        
        request.setAttribute(common.BeansConfig.rBookingCol, rBookingCol);
        
        session.setAttribute(common.URLConfig.isFrom(common.URLConfig.SURLo_checkout), true);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLo_checkout).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
