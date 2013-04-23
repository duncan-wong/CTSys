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

/**
 *
 * @author DUNCAN
 */
public class Search extends HttpServlet {

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
        String searchStr = request.getParameter("searchStr");
        //redirect to /movies if no search string
        if (searchStr == null || searchStr.equals("")){
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_movies));
            return;
        }
        
        //do search
        beans.RMovieCol rMovieCol_title = new beans.RMovieCol();
        rMovieCol_title.searchMovieName(searchStr);
        rMovieCol_title.fetchDBData();;
        
        beans.RMovieCol rMovieCol_author = new beans.RMovieCol();
        rMovieCol_author.searchMovieAuthor(searchStr);
        rMovieCol_author.fetchDBData();
        
        //add to request
        request.setAttribute(common.BeansConfig.rMovieCol_title, rMovieCol_title);
        request.setAttribute(common.BeansConfig.rMovieCol_author, rMovieCol_author);
        
        //dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_search).forward(request, response);
        
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
