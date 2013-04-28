/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovieShow;
import beans.RMovieShowCol;
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
public class M_MovieShow_edit extends HttpServlet {
    private String movieShowID;
    private String duration;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // call from a url-pattern
        // provide the registration form
        movieShowID = request.getParameter("movieShowID");
        duration = request.getParameter("duration");
        RMovieShow rMovieShow = new RMovieShow();
        rMovieShow.setMovieShowID(movieShowID);
        rMovieShow.fetchDBData();
        request.setAttribute("rMovieShow", rMovieShow);
        
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
            String start = startDate+" "+startTime;
            String end = servlets.helper.Helper.addMinutesToStringDate(start, "yyyy.MM.dd HH:mm", duration);
            
            // check house is free after the movie start
            RMovieShowCol checker1 = new RMovieShowCol();
            checker1.searchHouseID(houseID);
            checker1.searchInDayRange(0);
            checker1.searchTimeAfter(start);
            checker1.fetchDBData();
            
            // check house is free before the movie end
            RMovieShowCol checker2 = new RMovieShowCol();
            checker2.searchHouseID(houseID);
            checker2.searchInDayRange(0);
            checker2.searchTimeAfter(end);
            checker2.fetchDBData();
            
            // check house is showing this movie at the start time
            RMovieShowCol checker3 = new RMovieShowCol();
            checker3.searchHouseID(houseID);
            checker3.searchInDayRange(0);
            checker3.searchTimeAfter(start);
            checker3.searchMovieShowID(movieShowID);
            checker3.fetchDBData();
            
            // check house is showing this movie at the end time
            RMovieShowCol checker4 = new RMovieShowCol();
            checker4.searchHouseID(houseID);
            checker4.searchInDayRange(0);
            checker4.searchTimeAfter(end);
            checker4.searchMovieShowID(movieShowID);
            checker4.fetchDBData();
            
            if (checker1.count() == checker3.count() && checker2.count() == checker4.count()) {
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
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_MovieShow_edit).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
