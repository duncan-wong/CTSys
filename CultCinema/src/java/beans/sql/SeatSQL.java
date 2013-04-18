/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class SeatSQL {
    // 1 search     showing_id ( Default : show all )
    public static final String
            s1 = "{ call show_BookedSeat(?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      showing_id
    // 2 input      booking_id
    // 3 input      row_number
    // 4 input      seat_number
    // 5 input      discount_percent ( Default : 100 )
    public static final String
            i5 = "{ ? = call insert_BookedSeat(?,?,?,?,?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      showing_id
    public static final String
            d1 = "{ ? = call delete_BookedSeat(?) }";
}
