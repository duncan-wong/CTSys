/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovieShow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
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
    private String movieId;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        movieShowID = request.getParameter("movieShowID");
        movieId = request.getParameter("movieId");
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        request.setAttribute("rMovieShow", rMovieShow);
        request.setAttribute("id", movieId);
        
        // dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_remove).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        
        try {
            rMovieShow.commitDelete();
            isCommitted = true;
        }
        catch(Exception e){
            errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
        }
        
        if (isCommitted) {
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLm_MovieShow));
        }
        else {
            request.setAttribute("rMovieShow", rMovieShow);
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute("id", movieId);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_remove).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
