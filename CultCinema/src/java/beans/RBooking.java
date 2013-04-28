/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.BookingSQL;
import beans.sqlColumnName.BookingColumn;
import beans.sqlColumnName.SeatColumn;
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
public class RBooking extends UpdatableBean {
    private String account_id;
    private String booking_id;
    private String payment_status;
    private String guest_email;
    
    // Below : are unchangable values
    private String showing_id;
    private String ticket_price;  // total spent of this booking
    private String num_of_ticket;
    private String booking_madeDate; // format : yyyy.MM.dd
    private String booking_madeTime;
    
    // web app internal use
    private RSeat[] selectedTickets;
    private int noOfTickets;
//-----------------------------------------------------------------------------
    public RBooking() {
        super();
        account_id = null;
        booking_id = null;
        payment_status = null;
        guest_email = null;
        
        showing_id = null;
        ticket_price = null;
        num_of_ticket = null;
        booking_madeDate = null;
        booking_madeTime = null;
        
        this.selectedTickets = null;
        
    }
    public RBooking(String booking_id) {
        this();
        this.booking_id = booking_id;
    }
//------------------------------------------------------------------------------
    public void setAccountID(String in) {
        set(BookingColumn.ACCOUNT_ID, in);
    }
    public void setBookingID(String in) {
        set(BookingColumn.BOOKING_ID, in);
    }
    public void setPaymentStatus(String in) {
        set(BookingColumn.PAYMENT_STATUS, in);
    }
    public void setGuestEmail(String in) {
        set(BookingColumn.GUEST_EMAIL, in);
    }
    private void set(String id, String in) {
        if (id.equals(BookingColumn.ACCOUNT_ID)) {
            account_id = in;
        }
        else if (id.equals(BookingColumn.BOOKING_ID)) {
            booking_id = in;
        }
        else if (id.equals(BookingColumn.PAYMENT_STATUS)) {
            payment_status = in;
        }
        else if (id.equals(BookingColumn.GUEST_EMAIL)) {
            guest_email = in;
        }
        this.setChangedTrue();
    }
    
    // Below : are unchangable values
    public void setBookingMadeDate(String in) {
        booking_madeDate = in;
    }
    public void setBookingMadeTime(String in) {
        booking_madeTime = in;
    }
    public void setMovieShowID(String in) {
        this.showing_id = in;
    }
    public void setTicketPrice(String in) {
        this.ticket_price = in;
    }
    public void setNumOfTicket(String in) {
        this.num_of_ticket = in;
        
        this.selectedTickets = new RSeat[Integer.valueOf(this.num_of_ticket)];
    }
    public void setNumOfTicket(int in) {
        this.num_of_ticket = Integer.toString(in);
        
        this.selectedTickets = new RSeat[Integer.valueOf(this.num_of_ticket)];
    }
    public void setSelectedTickets(RSeat[] seats){
        this.selectedTickets = seats;
    }
    
    
//------------------------------------------------------------------------------
    public String getAccountID() {
        return account_id;
    }
    public String getBookingID() {
        return booking_id;
    }
    public String getPaymentStatus() {
        return payment_status;
    }
    public boolean isGuest() {
        if (account_id.equals("0")) {
            return true;
        }
        return false;
    }
    public String getGuestEmail() {
        return guest_email;
    }
    
    // Below : are unchangable values
    public String getBookingMadeDate() {
        return booking_madeDate;
    }
    public String getBookingMadeTime() {
        return booking_madeTime;
    }
    public String getMovieShowID() {
        return showing_id;
    }
    public float getTicketPrice() {
        return Float.valueOf(ticket_price);
    }
    public int getNumOfTicket() {
        return Integer.parseInt(num_of_ticket);
    }
    public RSeat[] getBookedSeat() {
        ArrayList<RSeat> seats = new ArrayList<RSeat>();
        try {
            DBconnect db = new DBconnect(BookingSQL.s2_ShowSeat);
            db.setXxx(1, showing_id);
            db.setXxx(2, booking_id);
            db.executeQuery();
            while (db.queryHasNext()) {
                RSeat temp = new RSeat();
                temp.setRowNum(db.getXxx(SeatColumn.ROW_NUMBER, 0));
                temp.setSeatNum(db.getXxx(SeatColumn.SEAT_NUMBER, 0));
                temp.afterInitialization();
                seats.add(temp);
            }
            db.disconnect();
            return seats.toArray(new RSeat[seats.size()]);
        } catch (NamingException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public RSeat[] getSelectedTickets(){
        return this.selectedTickets;
    }
    
    public boolean getIsLoyaltyPaid(){
        return beans.accessInterface.BookingPaymentStatus.Loyalty_Paid.equals(this.payment_status);
    }
    
    public boolean getIsDeferred(){
        return beans.accessInterface.BookingPaymentStatus.Payment_Deferred.equals(this.payment_status);
    }
    
    public boolean getIsIncomplete(){
        return beans.accessInterface.BookingPaymentStatus.Payment_Incomplete.equals(this.payment_status);
    }
    
    public boolean getIsComplete(){
        return beans.accessInterface.BookingPaymentStatus.Payment_Complete.equals(this.payment_status);
    }
    
    public boolean getIsRefundAccepted(){
        return beans.accessInterface.BookingPaymentStatus.Refund_Accepted.equals(this.payment_status);
    }
    
    public boolean isBeforeHours(int hours){
        return true;
    }
    
//------------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect(BookingSQL.s6);
            db.setXxx(1, account_id);
            db.setXxx(2, null);
            db.setXxx(3, null);
            db.setXxx(4, booking_id);
            db.setXxx(5, payment_status);
            db.setXxx(6, guest_email);
            db.executeQuery();
            if (db.queryHasNext()) {
                account_id = db.getXxx(BookingColumn.ACCOUNT_ID);
                guest_email = db.getXxx(BookingColumn.GUEST_EMAIL);
                payment_status = db.getXxx(BookingColumn.PAYMENT_STATUS);
                showing_id = db.getXxx(BookingColumn.SHOWING_ID);
                ticket_price = db.getXxx(BookingColumn.TICKET_PRICE);
                num_of_ticket = db.getXxx(BookingColumn.NUM_OF_TICKET);
                booking_madeDate = db.getXxx("booking_madeDate");
                booking_madeTime = db.getXxx("booking_madeTime");
            }
            db.disconnect();
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean commitChange() {
        super.commitChange();
        if (this.isNew()) {
            return commitInsert();
        }
        else if (this.isChanged()) {
            return commitUpdate();
        }
        return true;
    }
    
    public boolean commitInsert() {
        try {
            DBconnect db = new DBconnect(BookingSQL.i2);
            db.setResult();
            db.setXxx(2, account_id);
            db.setXxx(3, guest_email);
            db.executeUpdate();
            booking_id = Integer.toString(db.getResult());
            db.disconnect();
            if (booking_id != null) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect("{ ? = call update_BookingStatus(?,?,?,?) }");
            db.setResult();
            db.setXxx(2, booking_id);
            db.setXxx(3, payment_status);
            db.setXxx(4, account_id);
            db.setXxx(5, guest_email);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // soft delete
    public boolean commitCancel() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(BookingSQL.d1);
            db.setResult();
            db.setXxx(2, booking_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // hard delete
    public boolean commitDelete() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect("{ ? = call delete_Booking_hard(?) }");
            db.setResult();
            db.setXxx(2, booking_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
