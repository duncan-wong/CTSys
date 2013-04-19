/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public class ShowSeatingSQL {
    // 1 search     showing_id ( Default : show all )
    public static final String
            s1 = "{ call show_BookedSeat(?) }";
//-----------------------------------------------------------------------------
    // 1 search     house_id ( can be null )
    // 2 search     showing_id ( can be null )
    public static final String
            s2_seatPlan = "{ call show_HouseRow(?,?) }";
}
