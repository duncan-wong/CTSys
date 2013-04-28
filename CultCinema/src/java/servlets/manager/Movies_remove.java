/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class Movies_remove extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RMovie rMovie = new RMovie();
        rMovie.setMovieID(request.getParameter("movieId"));
        rMovie.fetchDBData();
        request.setAttribute("rMovie", rMovie);
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_m_Movies_remove).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RMovie rMovie = new RMovie();
        rMovie.setMovieID(request.getParameter("movieId"));
        rMovie.fetchDBData();
        rMovie.commitDelete();
        response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_m_Movies));
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
