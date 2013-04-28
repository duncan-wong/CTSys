/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovieShow;
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
public class M_MovieShow_remove extends HttpServlet {
    private String movieShowID;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        movieShowID = request.getParameter("movieShowID");
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        request.setAttribute("rMovieShow", rMovieShow);
        
        // dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_remove).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        rMovieShow.commitDelete();
        
        // redirect
        response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLm_MovieShow));
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
