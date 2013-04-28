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

/**
 *
 * @author A
 */
public class Movies_edit extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RMovie rMovie = new RMovie();
        rMovie.setMovieID(request.getParameter("movieId"));
        rMovie.fetchDBData();
        
        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        String name = request.getParameter("movieName");
        String author = request.getParameter("movieAuthor");
        String duration = request.getParameter("movieDuration");
        String startDate = request.getParameter("movieStartDate");
        String endDate = request.getParameter("movieEndDate");
        String description = request.getParameter("movieDescription");
        
        if (!common.Validation.isNull(name)) {
            rMovie.setMovieName(new String(name.getBytes("ISO-8859-1"), "UTF-8"));
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("movieName", "Invalid Movie Name");
        }
        
        if (!common.Validation.isNull(author)) {
            rMovie.setMovieAuthor(new String(author.getBytes("ISO-8859-1"), "UTF-8"));
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("movieAuthor", "Invalid Movie Director");
        }
        
        if (!common.Validation.isNull(duration)
            && common.Validation.isOnlyDigit(duration)) {
            rMovie.setMovieDuration(new String(duration.getBytes("ISO-8859-1"), "UTF-8"));
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("movieDuration", "Invalid Movie Duration");
        }
        
        if (!common.Validation.isNull(startDate)
            && !common.Validation.isNull(endDate)
            && common.Validation.isDateSmaller(startDate, endDate)) {
            rMovie.setMovieStartDate(new String(startDate.getBytes("ISO-8859-1"), "UTF-8"));
            rMovie.setMovieEndDate(new String(endDate.getBytes("ISO-8859-1"), "UTF-8"));
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("movieDate", "Invalid Date");
        }
        
        if (!common.Validation.isNull(description)) {
            rMovie.setMovieDescription(new String(description.getBytes("ISO-8859-1"), "UTF-8"));
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("movieDescription", "Invalid Description");
        }
        
        
        if (isSafeToCommit) {
            try {
                rMovie.commitChange();
                isCommitted = true;
            }
            catch(Exception e){
                errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
            }
        }
        
        if (isCommitted) {
            response.sendRedirect(request.getContextPath()+"/manager/movies");
        }
        else {
            request.setAttribute("rMovie", rMovie);
            request.setAttribute("errorMsg", errorMsg);
            this.getServletContext().getRequestDispatcher("/WEB-INF/manager/movies_edit.jsp").forward(request, response);
        }
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //redirect for request not from manager/movies
        response.sendRedirect(request.getContextPath()+"/manager/movies");
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getAttribute(common.URLConfig.isFrom("/manager/movies")) != null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/manager/movies_edit.jsp").forward(request, response);
        }
        else {
            processRequest(request, response);
        }
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
