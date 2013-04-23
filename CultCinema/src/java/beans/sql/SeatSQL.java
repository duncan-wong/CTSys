/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public class SeatSQL {
    // 0 output     -1 if error
    // 1 input      house_id
    // 2 input      row_number
    // 3 input      seat_number
    // 4 input      active
    public static final String
            u4_House = "{ ? = call update_HouseSeat(?,?,?,?) }";
//------------------------------------------------------------------------------
    // 1 search     showing_id
    public static final String
            s1_Showing = "{ call show_ShowingSeat(?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      showing_id
    // 2 input      row_number
    // 3 input      seat_number
    // 4 input      booking_id
    public static final String
            i4_Showing = "{ ? = call insert_ShowingSeat(?,?,?,?) }";
}
