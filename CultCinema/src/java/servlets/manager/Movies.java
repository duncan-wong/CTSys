/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A
 */
public class Movies extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        beans.RMovieCol managerMovieCol = new beans.RMovieCol();
        
        // fetch information
        managerMovieCol.changeLang(sStatus.getLanguageOption());
        managerMovieCol.fetchDBData();
        
        // put the bean into request
        request.setAttribute("managerMovieCol", managerMovieCol);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/manager/movies.jsp").forward(request, response);
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(common.URLConfig.isFrom("/manager/movies"), true);
        
        processRequest(request, response);
        
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
