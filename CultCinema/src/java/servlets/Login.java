package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import beans.*;

/**
 *
 * @author DUNCAN
 */
public class Login extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        
        //add request bean
        beans.RLogin rLogin = new beans.RLogin();
        request.setAttribute("rLogin", rLogin);
        
        //if the user is not logged in
        if (request.getUserPrincipal() == null){
            //if login error
            //fill RLogin bean to pass back the error message
            if (request.getServletPath().contains(URLConfig.SURL_loginError)){
                rLogin.setErrorMessage("Username or password is incorrect");
                request.setAttribute("rLogin", rLogin);
                //dispatch to log in page
                this.getServletContext().getRequestDispatcher(URLConfig.JURL_login).forward(request, response);
            }
            // /login is called by java container before any servlet
            else{
                beans.SStatus sStatus = new beans.SStatus();
                session.setAttribute(BeansConfig.sStatus, sStatus);
            }
            //dispatch to log in page
            this.getServletContext().getRequestDispatcher(URLConfig.JURL_login).forward(request, response);
            
        }
        else{
            //if /logout
            //invalidate the session and clean up the session information
           if (request.getServletPath().contains(URLConfig.SURL_logout)){
                session.invalidate();
            }
            
            //redirect the user to index page after actively logging in
            response.sendRedirect(URLConfig.getFullPath(URLConfig.SURL_index));
            
        }
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
     * Handle LOGIN process
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
