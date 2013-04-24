/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
 * @author DUNCAN
 */
public class OrderTicket extends HttpServlet {
    private String[] stepTrace = {
        "/select_movie_show",
        "/select_seat",
        "/payment",
        "/complete"
    };

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //called from a url-pattern
        
        
        //redirect to /movies if there is no movie selected
        if (request.getParameter("movieId") == null || request.getParameter("movieId").equals("")){
            this.unauthorizedAccess(response);
            return;
        }
        
        //-------------------
        //initialize booking
        //put booking into session object
        //------------------
        
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        
        //create new booking
        beans.SBooking sBooking = new beans.SBooking();
        session.setAttribute(common.BeansConfig.sBooking, sBooking);
        
        
        //create RHouse object as request bean
        beans.RHouseCol rHouseCol = new beans.RHouseCol();
        rHouseCol.fetchDBData();
        
        //put it into the request
        request.setAttribute(common.BeansConfig.rHouseCol, rHouseCol);
        if (!this.perpareReuqest(request, response)){
            this.unauthorizedAccess(response);
            return;
        }
        
        //add trace attribute to session
        session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[1]);
        
        //dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_time).forward(request, response);
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //called when continuesly in the same booking
        
        
        //get trace attribute in session
        HttpSession session = request.getSession(false);
        String nextStep = (String) session.getAttribute(common.URLConfig.nextInternalUrl);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        //get urlencoded movie id
        String movieId = (String) request.getParameter("movieId");
        
        
        //get current sBooking from session
        beans.SBooking sBooking = (beans.SBooking) session.getAttribute(common.BeansConfig.sBooking);
        if (sBooking == null){
            this.unauthorizedAccess(response);
            return;
        }
        
        //create RHouse object as request bean
        beans.RHouseCol rHouseCol = new beans.RHouseCol();
        rHouseCol.fetchDBData();
        
        //put it into the request
        request.setAttribute(common.BeansConfig.rHouseCol, rHouseCol);
        
        //prepare request
        if (!this.perpareReuqest(request, response)){
            this.unauthorizedAccess(response);
            return;
        }
        
        if(this.stepTrace[1].equals(nextStep)){
            //handle selected movieShow and select seat
            
            String movieShowId = "1";
            if (request.getParameter("movieShowId") != null){
                movieShowId = request.getParameter("movieShowId");
            }
            else if (sBooking.getMovieShowID() != null){
                movieShowId = sBooking.getMovieShowID();
            }
            else{
                this.unauthorizedAccess(response);
                return;
            }
            
            //create movieShow object
            beans.RMovieShow rMovieShow = new beans.RMovieShow();
            rMovieShow.setMovieShowID(movieShowId);
            //update sBooking if the movie show exist
            if (rMovieShow.fetchDBData()){
                sBooking.setMovieShowID(movieShowId);
            }
            else{
                this.unauthorizedAccess(response);
                return;
            }
            
            //fill in sBooking
            sBooking.setMovieShowID(movieShowId);
            
            
            //preparation for selecting seats
            //get house seat
            beans.RHouse rHouse = new beans.RHouse();
            rHouse.setMovieShowID(movieShowId);
            rHouse.fetchDBData();
            
            //add beans to request
            request.setAttribute(common.BeansConfig.rMovieShow, rMovieShow);
            request.setAttribute(common.BeansConfig.rHouse, rHouse);
            
            //if seats had been selected before
            if(sBooking.getSelectedTickets() != null){
                String selectedSeatsIdStr = "";
                beans.RSeat[] selectedTickets = sBooking.getSelectedTickets();
                for (int i = 0; i < sBooking.getSelectedTickets().length; i ++){
                    if (i > 0) {
                        selectedSeatsIdStr += ",";
                    }
                    selectedSeatsIdStr += selectedTickets[i].getRowNum() + "-" + selectedTickets[i].getSeatNum();
                }
                request.setAttribute("selectedSeatsId", selectedSeatsIdStr);
            }
            
            //update trace attribute in session
            if(sBooking.getMovieShowID() != null){
                session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[2]);
            }
            
            //dispatch
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_seat).forward(request, response);
        }
        else if(this.stepTrace[2].equals(nextStep)){
            //handle selected seat and make payment
            
            
            //handle selected seat
            //and update trace attribute in session
            String selectedSeatsStr = request.getParameter("selectedSeats") ;
            
            
            if (selectedSeatsStr != null && !selectedSeatsStr.equals("")){
                String[] selectedSeatsId = selectedSeatsStr.split(",");
                java.util.Arrays.sort(selectedSeatsId);
                
                if (selectedSeatsId.length > 0){
                    sBooking.setNumOfTicket(selectedSeatsId.length);
                    beans.RSeat[] selectedSeats = new beans.RSeat[selectedSeatsId.length];
                    for (int i = 0; i < selectedSeatsId.length; i ++){
                        //create tickets and put into sBooking
                        beans.RSeat ticket = new beans.RSeat();
                        ticket.setMovieShowID(sBooking.getMovieShowID());
                        String[] seatId = new String[2];
                        if (selectedSeatsId[i].contains("-")){
                            seatId[0] = selectedSeatsId[i].split("-")[0];
                            seatId[1] = selectedSeatsId[i].split("-")[1];
                            ticket.setRowNum(Integer.valueOf(seatId[0]));
                            ticket.setSeatNum(Integer.valueOf(seatId[1]));
                        }
                        else{
                            this.unauthorizedAccess(response);
                            return;
                        }
                        
                        selectedSeats[i] = ticket;
                    }
                    sBooking.setSelectedTickets(selectedSeats);
                }
                else{
                    this.unauthorizedAccess(response);
                    return;
                }
                
                
            }
            else if (sBooking.getSelectedTickets() == null){
                session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[1]);
                //dispatch to select seat
                this.getServletContext().getRequestDispatcher(common.URLConfig.SURL_orderTicket).forward(request, response);
            }
            
            //parepare request for confirm booking page
            beans.RMovieShow rMovieShow = new beans.RMovieShow();
            rMovieShow.setMovieShowID(sBooking.getMovieShowID());
            rMovieShow.fetchDBData();
            request.setAttribute(common.BeansConfig.rMovieShow, rMovieShow);

            request.setAttribute(common.BeansConfig.sBooking, sBooking);

            //update trace attribute
            session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[3]);

            //dispatch to confirm booking\
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_info).forward(request, response);
            
        }
        else if(this.stepTrace[3].equals(nextStep)){
            //handle confirmation booking request and payment
            
            //go backward
            if ("1".equals(request.getParameter("backward"))){
                //update trace attribute
                session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[1]);

                //dispatch to seat
                this.getServletContext().getRequestDispatcher(common.URLConfig.SURL_orderTicket+"?movieId="+request.getParameter("movieId")).forward(request, response);
                return;
            }
            
            //purphase
            if (sBooking.getSelectedTickets() != null){
                
            }
            else{
                this.unauthorizedAccess(response);
                return;
            }
            
            //update trace attribute
            session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[3]);

            //dispatch to confirm booking
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_info).forward(request, response);
        }
        else{
            session.setAttribute(common.URLConfig.nextInternalUrl, null);
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_orderTicket)+"?movieId="+request.getParameter("movieId"));
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
    
    //redirect to /movies for unauthorized access
    private void unauthorizedAccess(HttpServletResponse response) throws IOException{
        response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_movies));
    }
    
    //regular perpartion for request
    private boolean perpareReuqest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        //get urlencoded movie id
        String movieId = (String) request.getParameter("movieId");
        
        //create RMovie object as request bean
        beans.RMovie rCurrentMovie = new beans.RMovie();
        rCurrentMovie.setLanguage(sStatus.getLanguageOption());
        rCurrentMovie.setMovieID(movieId);
        if (!rCurrentMovie.fetchDBData()){
            return false;
        }
        
        //put it into the request
        request.setAttribute(common.BeansConfig.rCurrentMovie, rCurrentMovie);
        return true;
    }
}
