/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public abstract class MovieSQL {
    // 1 search		language_code ( Default 'en' )
    // 2 search		movie_id
    // 3 search		movie_name
    // 4 search		movie_author
    // 5 order by	column
    public static final String
            s5 = "{ call show_Movie(?,?,?,?,?) }";
//----------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input		movie_name
    // 2 input		movie_author
    // 3 input		movie_description
    // 4 input		movie_startDate
    // 5 input		movie_endDate
    // 6 input		movie_duration
    public static final String
            i6 = "{ ? = call insert_Movie(?,?,?,?,?,?) }";
//----------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      language_code
    // 2 input      movie_id
    // 3 input      movie_name
    // 4 input      movie_author
    // 5 input      movie_description
    // 6 input      movie_duration
    // 7 input      movie_startDate
    // 8 input      movie_endDate
    public static final String
            u8 = "{ ? = call update_Movie(?,?,?,?,?,?,?,?) }";
//----------------------------------------------------------------------------
    // 0 output     -1 if have error
    // 1 input      movie_id
    public static final String
            d1 = "{ ? = call delete_Movie(?) }";
    
}
