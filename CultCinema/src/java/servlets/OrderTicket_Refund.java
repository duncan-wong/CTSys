/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 52593578
 */
public class OrderTicket_Refund extends HttpServlet {

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
        if (session.getAttribute(common.URLConfig.isFrom(common.URLConfig.SURL_account)) != null){
            session.setAttribute(common.URLConfig.isFrom(common.URLConfig.SURL_account), null);
            
            if (request.getParameter("bid") != null && !request.getParameter("bid").equals("")){
                beans.RBooking booking = new beans.RBooking(request.getParameter("bid"));
                if (booking.fetchDBData()){
                    if (!servlets.orderTicketHelper.BookingHandler.requestRefund(request, booking)){
                        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
                        beans.accessInterface.LanguageBean lb = beans.languageBeans.LanguageBeanPicker.getLanguageBean(sStatus.getLanguageOption());
                        servlets.helper.Helper.addErrorMsgToSession(request, "refundError", lb.errorRefund());
                    }
                }
            }
            
        }
        response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_account));
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
