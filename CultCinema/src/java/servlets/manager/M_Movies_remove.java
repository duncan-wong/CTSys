/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A
 */
public class M_Movies_remove extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        RMovie rMovie = new RMovie();
        rMovie.setMovieID(request.getParameter("movieId"));
        rMovie.setLanguage(sStatus.getLanguageOption());
        rMovie.fetchDBData();
        
        request.setAttribute("rMovie", rMovie);
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_Movies_remove).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        RMovie rMovie = new RMovie();
        rMovie.setMovieID(request.getParameter("movieId"));
        rMovie.setLanguage(sStatus.getLanguageOption());
        rMovie.fetchDBData();
        
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        
        try {
            rMovie.commitDelete();
            isCommitted = true;
        }
        catch(Exception e){
            errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
        }
        
        if (isCommitted) {
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLm_Movies));
        }
        else {
            request.setAttribute("rMovie", rMovie);
            request.setAttribute("errorMsg", errorMsg);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_Movies_remove).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
