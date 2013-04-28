/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovieShow;
import beans.RMovieShowCol;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class M_MovieShow_create extends HttpServlet {
    private String duration;
    private String movieID;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // call from a url-pattern
        // provide the registration form
        duration = request.getParameter("duration");
        movieID = request.getParameter("movieID");
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieID(request.getParameter("movieId"));
        request.setAttribute("rMovieShow", rMovieShow);
        
        // dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_create).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieID(movieID);
        
        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();

        String houseID = request.getParameter("houseID");
        String startDate = request.getParameter("startDate");
        String startTime = request.getParameter("startTime");
        String ticketPrice = request.getParameter("ticketPrice");
        
        
        if (!common.Validation.isNull(houseID)) {
            rMovieShow.setHouseID(houseID);
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("houseID", "Please choose a house");
        }
        
        if (common.Validation.isCorrectDateString(startDate)) {
            // check house is free after the movie start
            String start = startDate+" "+startTime;
            RMovieShowCol checker = new RMovieShowCol();
            checker.searchHouseID(houseID);
            checker.searchInDayRange(0);
            checker.searchTimeAfter(start);
            checker.fetchDBData();
            
            // check house is free before the movie end
            String end = servlets.helper.Helper.addMinutesToStringDate(start, "yyyy.MM.dd HH:mm", duration);
            RMovieShowCol checker2 = new RMovieShowCol();
            checker2.searchHouseID(houseID);
            checker2.searchInDayRange(0);
            checker2.searchTimeAfter(end);
            checker2.fetchDBData();
            
            if (checker.count() == 0 && checker2.count() == 0) {
                rMovieShow.setMovieShowStartDate(startDate);
                rMovieShow.setMovieShowStartTime(startTime);
            }
            else {
                isSafeToCommit = false;
                errorMsg.put("startDate", "The house is not free yet");
            }
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("startDate", "Please enter the showing time");
        }
        
        if (common.Validation.isPhone(ticketPrice)) {
            rMovieShow.setTicketPrice(ticketPrice);
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("ticketPrice", "Please enter the ticket price");
        }
        
        
        
        if (isSafeToCommit) {
            try {
                rMovieShow.commitChange();
                isCommitted = true;
            }
            catch(Exception e){
                errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
            }
        }
        
        if (isCommitted) {
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLm_MovieShow));
        }
        else {
            request.setAttribute("rMovieShow", rMovieShow);
            request.setAttribute("errorMsg", errorMsg);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_create).forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
