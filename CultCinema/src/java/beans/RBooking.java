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
//-----------------------------------------------------------------------------
    public RBooking() {
        super();
        account_id = null;
        booking_id = null;
        payment_status = null;
        guest_email = null;
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
        if (id == BookingColumn.ACCOUNT_ID) {
            account_id = in;
        }
        else if (id == BookingColumn.BOOKING_ID) {
            booking_id = in;
        }
        else if (id == BookingColumn.PAYMENT_STATUS) {
            payment_status = in;
        }
        else if (id == BookingColumn.GUEST_EMAIL) {
            guest_email = in;
        }
        this.setChangedTrue();
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
    public String getGuestEmail() {
        return guest_email;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect(BookingSQL.s6);
            db.setXxx(1, null);
            db.setXxx(2, null);
            db.setXxx(3, null);
            db.setXxx(4, booking_id);
            db.setXxx(5, null);
            db.setXxx(6, null);
            db.executeQuery();
            if (db.queryHasNext()) {
                account_id = db.getXxx(BookingColumn.ACCOUNT_ID);
                guest_email = db.getXxx(BookingColumn.GUEST_EMAIL);
                payment_status = db.getXxx(BookingColumn.PAYMENT_STATUS);
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
        if (this.isNew()) {
            return commitInsert();
        }
        else if (this.isChanged()) {
            return commitUpdate();
        }
        return true;
    }
    
    public boolean commitInsert() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(BookingSQL.i2);
            db.setResult();
            db.setXxx(2, account_id);
            db.setXxx(3, guest_email);
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
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(BookingSQL.u2);
            db.setResult();
            db.setXxx(2, booking_id);
            db.setXxx(3, payment_status);
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
    public boolean commitDelete() {
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
}
