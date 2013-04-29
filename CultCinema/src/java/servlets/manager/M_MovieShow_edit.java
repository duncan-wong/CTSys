/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovieShow;
import beans.RMovieShowCol;
import common.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.helper.Helper;

/**
 *
 * @author A
 */
public class M_MovieShow_edit extends HttpServlet {
    private String movieId;
    private String movieShowID;
    private String duration;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // call from a url-pattern
        // provide the registration form
        movieId = request.getParameter("movieId");
        movieShowID = request.getParameter("movieShowID");
        duration = request.getParameter("duration");
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        request.setAttribute("rMovieShow", rMovieShow);
        request.setAttribute("id", movieId);
        
        // dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_edit).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        
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
            
            String format = "yyyy.MM.dd HH:mm";
            int movieLength = Integer.parseInt(duration);
            String start = startDate +" "+ startTime;
            String end = servlets.helper.Helper.addMinutesToStringDate(start, format, duration);
            String oStart = rMovieShow.getMovieShowStartDate() +" "+ rMovieShow.getMovieShowStartTime();
            String oEnd = rMovieShow.getMovieShowEndDate() +" "+ rMovieShow.getMovieShowEndTime();
            boolean houseIsFree = true;
            
            // stepper
            int mins = 15;
            
            int i = 0;
            String checkTime = start;
            // check the house is free between
            // [ start <= i < oStart ]
            while (i < movieLength
                && Validation.isDateSmaller(Helper.addMinutesToStringDate(checkTime, format, "1"), oStart, format)) {
                
                RMovieShowCol checker = new RMovieShowCol();
                checker.searchHouseID(houseID);
                checker.searchInDayRange(0);
                checker.searchTimeAfter(checkTime);
                checker.fetchDBData();
                if (checker.count() != 0) {
                    houseIsFree = false;
                }
                i += mins;
                checkTime = Helper.addMinutesToStringDate(checkTime, format, Integer.toString(mins));
            }
            // check the house is free between
            // [ oEnd <= i < end ]
            i = 0;
            checkTime = oEnd;
            while (i < movieLength
                && Validation.isDateSmaller(Helper.addMinutesToStringDate(checkTime, format, "1"), end, format)) {
                
                RMovieShowCol checker = new RMovieShowCol();
                checker.searchHouseID(houseID);
                checker.searchInDayRange(0);
                checker.searchTimeAfter(checkTime);
                checker.fetchDBData();
                if (checker.count() != 0) {
                    houseIsFree = false;
                }
                i += mins;
                checkTime = Helper.addMinutesToStringDate(checkTime, format, Integer.toString(mins));
            }
            // check house if free at
            // [ i == end ]
            RMovieShowCol checker = new RMovieShowCol();
            checker.searchHouseID(houseID);
            checker.searchInDayRange(0);
            checker.searchTimeAfter(end);
            checker.fetchDBData();
            if (checker.count() != 0) {
                houseIsFree = false;
            }
            
            
            if (houseIsFree) {
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
            request.setAttribute("id", movieId);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_edit).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
