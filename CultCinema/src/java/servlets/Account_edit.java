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
public class Account_edit extends HttpServlet {

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
        //redirect to /account for request not by post
        response.sendRedirect((common.URLConfig.getFullPath(common.URLConfig.SURL_account)));
        
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
        
        //confirm the request is from /account
        //redirect if not
        if (request.getAttribute("isFrom_" + common.URLConfig.SURL_account) == null){
            this.processRequest(request, response);
        }
        
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        //put RUser bean into request
        beans.RUser rUser = new beans.RUser(sStatus.getLoginId());
        request.setAttribute(common.BeansConfig.rUser, rUser);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_account_edit).forward(request, response);
        
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
