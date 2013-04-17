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
 * @author DUNCAN
 */
public class OrderTicket extends HttpServlet {


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
        //called from a url-pattern
        
        
        //redirect to /movies if there is no movie selected
        if (request.getParameter("movieId") == null){
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_movies));
            return;
        }
        
        //create new ticket order
        beans.STicketOrder ticketOrder = new beans.STicketOrder();
        
        String movieId = (String) request.getAttribute("movieId");
        
        //create RMovie object as request bean
        beans.RMovie rCurrentMovie = new beans.RMovie();
        rCurrentMovie.setMovieID(movieId);
        rCurrentMovie.fetchDBData();
        
        //put it into the request
        request.setAttribute(common.BeansConfig.rCurrentMovie, rCurrentMovie);
        
        //add trace attribute to session
        HttpSession session = request.getSession(false);
        session.setAttribute(common.URLConfig.lastInternalUrl, common.URLConfig.SURL_orderTicket);
        
        //dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_time).forward(request, response);
        
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
        //called when continuesly in the same ticket order
        
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