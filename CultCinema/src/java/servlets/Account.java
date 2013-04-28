/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import common.BeansConfig;
import common.URLConfig;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUNCAN
 */
public class Account extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        //put RUser bean into request
        beans.RUser rUser = new beans.RUser(sStatus.getLoginId());
        rUser.fetchDBData();
        request.setAttribute(BeansConfig.rUser, rUser);
        
        //rBookingCol
        beans.RBookingCol rBookingCol = new beans.RBookingCol();
        rBookingCol.searchAccountID(rUser.getAccountID());
        rBookingCol.fetchDBData();
        request.setAttribute(common.BeansConfig.rBookingCol, rBookingCol);
        
        session.setAttribute(common.URLConfig.isFrom(common.URLConfig.SURL_account), Boolean.TRUE);
        
        //dispatch in doGet, doPost
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
        
        //forward to account page(show info)
        this.getServletContext().getRequestDispatcher(URLConfig.JURL_account).forward(request, response);
        servlets.helper.Helper.clearErrorMsgInSession(request);
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
        
        //dispatch the request to /account/edit if Edit button is clicked
        
        //add attribute to request to confirm the origin
        request.setAttribute(common.URLConfig.isFrom(common.URLConfig.SURL_account), true);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.SURL_account_edit).forward(request, response);
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
