/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sqlColumnName.BookingColumn;

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
    public RBooking(String account_id) {
        this();
        this.account_id = account_id;
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
        return false;
    }
}
