/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 52593578
 */
public class OrderTicket_Cancel extends HttpServlet {

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
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        if (request.getParameter("bid") != null && !request.getParameter("bid").equals("")){
            beans.RBooking booking = new beans.RBooking(request.getParameter("bid"));
            if (booking.fetchDBData()){
                if (request.getRequestURI().contains(common.URLConfig.SURL_orderTicketHide)){
                     servlets.orderTicketHelper.BookingHandler.hideBooking(booking);
                }
                else{
                    servlets.orderTicketHelper.BookingHandler.deleteBooking(booking);
                }
            }
            if (!common.Validation.isNull(request.getParameter("next"))){
                if(request.getParameter("next").equals("account")){
                    response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_account));
                }
                else if(request.getParameter("next").equals("officer") && sStatus.getUserRole().equals(common.RolesConfig.Officer)){
                    response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLo_officer));
                }
            }
        }
        
        //clean up
        servlets.orderTicketHelper.BookingHandler.clearSessionCurrentBooking(session);
        
        response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_movies));
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
