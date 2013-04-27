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
public class Movies_create extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // call from a url-pattern
        // provide the registration form
        RMovie rMovie = new RMovie();
        request.setAttribute("rMovie", rMovie);
        
        // dispatch
        this.getServletContext().getRequestDispatcher("/WEB-INF/manager/movies_create.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // form submission
        RMovie rMovie = new RMovie();
        
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
            this.getServletContext().getRequestDispatcher("/WEB-INF/manager/movies_create.jsp").forward(request, response);
        }
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
