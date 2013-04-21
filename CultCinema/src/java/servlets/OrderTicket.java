/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
            
            String movieShowId = request.getParameter("movieShowId");
            
            //get movieShowId
            beans.RMovieShow rMovieShow = new beans.RMovieShow();
            rMovieShow.setShowingID(movieShowId);
            
            
            //update sBooking
            if (rMovieShow.fetchDBData()){
                sBooking.setShowingID(movieShowId);
            }
            
            //add to request
            request.setAttribute(common.BeansConfig.rMovieShow, rMovieShow);
            
            //update trace attribute in session
            if(sBooking.getShowingID() != null){
                session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[2]);
            }
            
            //dispatch
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_seat).forward(request, response);
        }
        else if(this.stepTrace[2].equals(nextStep)){
            //handle selected seat and make payment
            
            
            
            //update trace attribute in session
            if (request.getAttribute("seats") != null){
                session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[3]);
                //dispatch to payment
                this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_orderTicket_time).forward(request, response);
            }
            else{
                session.setAttribute(common.URLConfig.nextInternalUrl, this.stepTrace[1]);
                //dispatch to select seat
                this.getServletContext().getRequestDispatcher(common.URLConfig.SURL_orderTicket).forward(request, response);
            }
            
        }
        else if(this.stepTrace[3].equals(nextStep)){
            
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
