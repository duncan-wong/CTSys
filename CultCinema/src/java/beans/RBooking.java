/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;

/**
 *
 * @author A
 */
public class RBooking extends UpdatableBean {
    private String account_id;
    private String booking_id;
    private String booking_status;
    private String guest_email;
    private RTicket[] tickets;
//-----------------------------------------------------------------------------
    public RBooking() {
        account_id = null;
        booking_id = null;
        booking_status = null;
        guest_email = null;
        tickets = null;
    }
    public RBooking(String account_id) {
        this();
        this.account_id = account_id;
    }
//------------------------------------------------------------------------------
}
