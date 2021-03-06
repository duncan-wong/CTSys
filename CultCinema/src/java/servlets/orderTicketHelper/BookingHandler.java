
package servlets.orderTicketHelper;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *
 * @author DUNCAN
 */

public class BookingHandler {
    public static ConcurrentHashMap<String, String> ticketMonitor = new ConcurrentHashMap<String, String>();
    
    static public boolean makingNewBooking(HttpSession session,beans.SBooking bookingReq){
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        //remove the old booking if exist
        servlets.orderTicketHelper.BookingHandler.clearSessionCurrentBooking(session);
        
        beans.SBooking booking = new beans.SBooking();
        booking.setMovieShowID(bookingReq.getMovieShowID());
        booking.setNumOfTicket(0);
        booking.commitInsert();
        
        bookingReq.setBookingID(booking.getBookingID());
        //get ticket locks
        //return false if the current can't get all ticket locks
        for (int i = 0; i < bookingReq.getNumOfTicket(); i ++){
            if (!BookingHandler.getTicketLock(session, bookingReq.getSelectedTickets()[i])){
                booking.commitDelete();
                return false;
            }
        }
        
        //insert ticket 
        //return false if the ticket cannot be inserted correctly
        for (int i = 0; i < bookingReq.getNumOfTicket(); i ++){
            bookingReq.getSelectedTickets()[i].setBookingID(booking.getBookingID());
            if (!BookingHandler.makeNewTicket(bookingReq.getSelectedTickets()[i])){
                booking.commitDelete();
                return false;
            }
        }
        
        //release ticket locks 
        for (int i = 0; i < bookingReq.getNumOfTicket(); i ++){
            BookingHandler.releaseTicketLock(bookingReq.getSelectedTickets()[i]);
        }
        
        
        //record currentBooking
        sStatus.setCurrentBooking(bookingReq);
        
        return true;
    }
    
   //clear currentBooking
    static public void clearSessionCurrentBooking(HttpSession session){
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        if (sStatus != null){ 
            if (sStatus.getCurrentBooking() != null 
                && !beans.accessInterface.BookingPaymentStatus.Payment_Complete.equals(sStatus.getCurrentBooking().getPaymentStatus())){
                sStatus.getCurrentBooking().commitDelete();
                sStatus.getCurrentBooking().commitDelete();
            }
            sStatus.setCurrentBooking(null);
        }
    }
    
    
    //confirm booking with valid payment
    static public boolean makePayment(HttpSession session, beans.RBooking bookingReq, String paymentType){
        beans.RBooking checkObj = new beans.RBooking();
        checkObj.setBookingID(bookingReq.getBookingID());
        checkObj.fetchDBData();
        
        if ( beans.accessInterface.BookingPaymentStatus.Payment_Timeout.equals(checkObj.getPaymentStatus())){
            bookingReq.setSelectedTickets(null);
            bookingReq.setNumOfTicket(0);
            bookingReq.setBookingID(null);
            bookingReq.setGuestEmail(null);
            bookingReq.setAccountID(null);
            return false;
        }
        
        
        bookingReq.setPaymentStatus(paymentType);
        bookingReq.commitUpdate();
        
        //clear refund pending queue
        if (bookingReq.getSelectedTickets() != null){
            for (int i =0; i < bookingReq.getSelectedTickets().length; i ++){
                beans.RSeatQueue rSeatQ = new beans.RSeatQueue();
                rSeatQ.searchMovieShowID(bookingReq.getMovieShowID());
                rSeatQ.searchRowNumber(bookingReq.getSelectedTickets()[i].getRowNum());
                rSeatQ.searchSeatNumber(bookingReq.getSelectedTickets()[i].getSeatNum());
                rSeatQ.fetchDBData();
                for (int j = 0; j < rSeatQ.getQueue().length; j ++){
                    beans.RBooking oldBooking = new beans.RBooking(rSeatQ.getQueue()[i].getBookingID());
                    oldBooking.fetchDBData();
                    oldBooking.setPaymentStatus(beans.accessInterface.BookingPaymentStatus.Refund_Accepted);
                    oldBooking.commitUpdate();
                }
            }
        }
        
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        if (sStatus != null){
            sStatus.setCurrentBooking(null);
        }
        
        BookingHandler.clearSessionCurrentBooking(session);
        return true;
    }
    
    //request refund
    static public boolean requestRefund(HttpServletRequest request, beans.RBooking booking){
        HttpSession session = request.getSession();
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        beans.RUser user = new beans.RUser();
        user.setLoginID(sStatus.getLoginId());
        user.fetchDBData();
        
        //calculate price
        beans.RMovieShow movieShow = new beans.RMovieShow();
        movieShow.setMovieShowID(booking.getMovieShowID());
        movieShow.fetchDBData();
        int total = Integer.parseInt(movieShow.getTicketPrice()) * booking.getNumOfTicket();
        
        if (user.getLoyalty_int() < total){
            return false;
        }
        
        //refund
        booking.setPaymentStatus(beans.accessInterface.BookingPaymentStatus.Refund_Pending);
        booking.commitUpdate();
        
        return true;
    }
    
    //approve refund
    static public boolean approveRefund(HttpServletRequest request, beans.RBooking booking){
        
        //refund
        booking.setPaymentStatus(beans.accessInterface.BookingPaymentStatus.Refund_Accepted);
        booking.commitUpdate();
        
        return true;
    }
    
    //decline refund
    static public boolean declineRefund(HttpServletRequest request, beans.RBooking booking){
        
        //refund
        booking.setPaymentStatus(beans.accessInterface.BookingPaymentStatus.Refund_Declined);
        booking.commitUpdate();
        
        return true;
    }
    
    static public boolean deleteBooking(beans.RBooking bookingReq){
        bookingReq.commitDelete();
        return bookingReq.commitDelete();
    }
    
    static public boolean hideBooking(beans.RBooking bookingReq){
        bookingReq.setPaymentStatus(beans.accessInterface.BookingPaymentStatus.HIDE);
        return bookingReq.commitUpdate();
    }
    
    //get ticket lock, write lock
    static private synchronized boolean getTicketLock(HttpSession session, beans.RSeat ticket){
        //the ticket lock is available
        if (BookingHandler.ticketMonitor.get(ticket.getTicketID()) == null){
            BookingHandler.ticketMonitor.put(ticket.getTicketID(), session.getId());
            return true;
        }
        //the ticket lock is not available
        return false;
    }
    
    static private void releaseTicketLock(beans.RSeat ticket){
        BookingHandler.ticketMonitor.remove(ticket.getTicketID());
    }
    
    //insert ticket 
    //assume any other booking is either canceled, refund accepted or refund pending
    static private boolean makeNewTicket(beans.RSeat ticket){
        return ticket.commitChange();
    }
}
