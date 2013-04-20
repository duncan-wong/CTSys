/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class MovieShowSQL {
    // 1 search     dayBefore ( default : 365 )
    // 2 search     timeAfter ( default : now )
    // 3 search     house_id
    // 4 search     movie_id
    // 5 search     language
    // 6 search     showing_id
    public static final String 
            s6 = "{ call show_Showing(?,?,?,?,?,?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      house_id
    // 2 input      movie_id
    // 3 input      time ( showing start time )
    // 4 input      price
    public static final String
            i4 = "{ ? = call insert_Showing(?,?,?,?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      showing_id
    // 2 input      house_id
    // 3 input      movie_id
    // 4 input      showing_time
    // 5 input      ticket_price
    public static final String
            u5 = "{ ? = call update_Showing(?,?,?,?,?) }";
//-----------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      showing_id
    public static final String
            d1 = "{ ? = call update_Showing(?) }";
}
