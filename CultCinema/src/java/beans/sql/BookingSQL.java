/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class BookingSQL {
    // 1 search     account_id
    // 2 search     dateAfter
    // 3 search     dayBefore
    // 4 search     booking_id
    // 5 search     payment_status
    // 6 search     guest_email
    public static final String
            s6 = "{ call show_BookingGrouped(?,?,?,?,?,?) }";
//------------------------------------------------------------------------------
    // 0 output     booking_id
    // 1 input      account_id
    // 2 input      guest_email
    public static final String
            i2 = "{ ? = call insert_Booking(?,?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      booking_id
    public static final String
            d1 = "{ ? = call delete_Booking(?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      booking_id
    // 2 input      payment_status
    public static final String
            u2 = "{ ? = call update_BookingStatus(?,?) }";
}
