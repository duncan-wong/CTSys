/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

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
 * @author A
 */
public class M_MovieShow extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        beans.RMovie rCurrentMovie = new beans.RMovie();
        beans.RHouseCol rHouseCol = new beans.RHouseCol();
        
        // fetch info
        rCurrentMovie.setLanguage(sStatus.getLanguageOption());
        rCurrentMovie.setMovieID(request.getParameter("movieId"));
        rCurrentMovie.fetchDBData();
        rHouseCol.fetchDBData();
        
        
        // put the bean into request
        request.setAttribute("rCurrentMovie", rCurrentMovie);
        request.setAttribute("rHouseCol", rHouseCol);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_m_MovieShow).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
