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
    // 1 input      house_id
    public static final String
            s1 = "{ call show_House(?) }";
//------------------------------------------------------------------------------
    // 1 input      house_id
    public static final String
            s1_Seat = "{ call show_HouseSeat(?) }";
//------------------------------------------------------------------------------
    // 1 input      showing_id
    public static final String
            s1_ShowingSeat = "{ call show_ShowingSeat(?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      house_id
    // 2 input      house_name
    public static final String
            u2 = "{ ? = call update_HouseName(?,?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      house_name
    // 2 input      house_capacity
    // 3 input      total_row
    // 4 input      house_id
    //  -> 4: If provided, it is used to generate a new seating plan. But need to delete the original seating plan first.
    //    *** But I assumed no able to modify the seating plan ***
    public static final String
            i4 = "{ ? = call insert_HouseSeat(?,?,?,?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      house_id
    public static final String
            d1 = "{ ? = call delete_House(?) }";
//------------------------------------------------------------------------------
    // 0 output     -1 if error
    // 1 input      house_id
    public static final String
            d1_Seat = "{ ? = call delete_HouseSeat(?) }";
//------------------------------------------------------------------------------
    // 1 input      house_id
    public static final String
            s1_Sales = "{ call show_HouseSales(?) }";
}
