/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class HouseSQL {
    // 1 search     house_id
    public static final String
            s1 = "{ call show_House(?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      house_name
    // 2 input      house_capacity
    // 3 input      total row_number
    // 4 input      house_id ( if exist, run update. )
    //                       ( But the house_id need to be soft deleted )
    public static final String
            i4 = "{ ? = call insert_HouseRow(?,?,?,?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      house_id
    
    /* this will not delete house but instead delete all row details of
     * this house */
    public static final String
            d1 = "{ ? = call delete_HouseRow(?) }";
//-----------------------------------------------------------------------------
}
