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
        beans.SessionStatus sessionStatus = (beans.SessionStatus)session.getAttribute("sessionStatus");
        
        if (request.getUserPrincipal() != null){
            //if it is a new user login by manually triggering /login
            //create and fill SessionStatus bean
            if (sessionStatus.getIsLoggedIn() == false){
                
                //fill session status here
                //beans.SessionStatus sessionStatus = new beans.SessionStatus();
                //sessionStatus.setIsLoggedIn(true);
                //sessionStatus.setUserId(request.getUserPrincipal().getName());
                //####to be filled with user name
                //sessionStatus.setUserName(request.getUserPrincipal().getName());
                
                //put the bean in to session
                //session.setAttribute("sessionStatus", sessionStatus);
            }
            //if /logout
            //invalidate the session and clean up the session information
            else if (request.getServletPath().compareToIgnoreCase(URLConfig.SURL_logout) == 0){
                session.invalidate();
            }
            
            //redirect the user to index page after actively logging in
            response.sendRedirect(URLConfig.getFullPath(URLConfig.JURL_index));
            
        }
        else {
        //forward to log in page
            this.getServletContext().getRequestDispatcher(URLConfig.JURL_login).forward(request, response);
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
