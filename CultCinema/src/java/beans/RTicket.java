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
public class RTicket extends UpdatableBean {
    private String showing_id;
    private String row_number;
    private String seat_number;
    private String booking_id;
//-----------------------------------------------------------------------------
    public RTicket() {
        super();
        showing_id = null;
        row_number = null;
        seat_number = null;
        booking_id = null;
    }
    public RTicket(String booking_id) {
        this();
        this.booking_id = booking_id;
    }
//-----------------------------------------------------------------------------
}
