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
}
