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
            u4 = "{ ? = call update_HouseSeat(?,?,?,?) }";
}
