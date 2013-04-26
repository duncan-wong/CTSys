/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.BookingSQL;
import beans.sqlColumnName.BookingColumn;
import common.jdbc.DBconnect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author A
 */
public class RBookingCol extends UpdatableBean {
    private String search_accountID;
    private String search_dateAfter;
    private String search_dayBefore;
    private String search_bookingID;
    private String search_paymentStatus;
    private String search_guestEmail;
    private ArrayList<RBooking> bookings;
    private ArrayList<RBooking> bookingsWaitForDelete;
//------------------------------------------------------------------------------
    public RBookingCol() {
        search_accountID = null;
        search_dateAfter = null;
        search_dayBefore = null;
        search_bookingID = null;
        search_paymentStatus = null;
        search_guestEmail = null;
        bookings = new ArrayList<RBooking>();
        bookingsWaitForDelete = new ArrayList<RBooking>();
    }
//------------------------------------------------------------------------------
    public void searchAccountID(String account_id) {
        search_accountID = account_id;
    }
    public void searchDateAfter(String date) {
        search_dateAfter = date;
    }
    public void searchDayBefore(int day) {
        search_dayBefore = Integer.toString(day);
    }
    public void searchBookingID(String booking_id) {
        this.search_bookingID = booking_id;
    }
    public void searchPaymentStatus(String status) {
        search_paymentStatus = status;
    }
    public void searchGuestEmail(String guest_email) {
        search_guestEmail = guest_email;
    }
    public void deleteBooking(RBooking r) {
        bookings.remove(r);
        bookingsWaitForDelete.add(r);
    }
//------------------------------------------------------------------------------
    public RBooking[] getAllBooking() {
        return bookings.toArray(new RBooking[bookings.size()]);
    }
    public RBooking getAt(int i) {
        return bookings.get(i);
    }
//------------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        bookings.clear();
        try {
            DBconnect db = new DBconnect(BookingSQL.s6);
            db.setXxx(1, search_accountID);
            db.setXxx(2, search_dateAfter);
            db.setXxx(3, search_dayBefore);
            db.setXxx(4, search_bookingID);
            db.setXxx(5, search_paymentStatus);
            db.setXxx(6, search_guestEmail);
            db.executeQuery();
            while (db.queryHasNext()) {
                RBooking temp = new RBooking();
                temp.setAccountID(search_bookingID);
                temp.setBookingID(db.getXxx(BookingColumn.BOOKING_ID));
                temp.setGuestEmail(db.getXxx(BookingColumn.GUEST_EMAIL));
                temp.setNumOfTicket(db.getXxx(BookingColumn.NUM_OF_TICKET));
                temp.setPaymentStatus(db.getXxx(BookingColumn.PAYMENT_STATUS));
                temp.setTicketPrice(db.getXxx(BookingColumn.TICKET_PRICE));
                temp.setMovieShowID(db.getXxx(BookingColumn.SHOWING_ID));
                temp.setBookingMadeDate(db.getXxx("booking_madeDate"));
                temp.setBookingMadeTime(db.getXxx("booking_madeTime"));
                temp.afterInitialization();
                bookings.add(temp);
            }
            db.disconnect();
            return fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RBookingCol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBookingCol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean commitChange() {
        for (int i=0; i<bookings.size(); i++) {
            if (!bookings.get(i).commitChange()) {
                return false;
            }
        }
        for (int i=0; i<bookingsWaitForDelete.size(); i++) {
            if (!bookingsWaitForDelete.get(i).commitDelete()) {
                return false;
            }
        }
        bookingsWaitForDelete.clear();
        return true;
    }
}
