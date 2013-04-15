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
    // 1 search     language code ( default 'en' )
    // 2 search     movie id
    // 3 search     movie name
    // 4 search     movie author
    // 5 order by   column
    public static final String
            s0 = "{ call show_Movie }",
            s1 = "{ call show_Movie(?) }",
            s2 = "{ call show_Movie(?,?) }",
            s3 = "{ call show_Movie(?,?,?) }",
            s4 = "{ call show_Movie(?,?,?,?) }",
            s5 = "{ call show_Movie(?,?,?,?,?) }";
//----------------------------------------------------------------------------
    // 1 movie      name
    // 2 movie      author
    // 3 movie      description
    // 4 movie      start date
    // 5 movie      end date
    // 6 movie      duration
    // 7 movie      language
    public static final String
            i0 = "{ call insert_Movie }",
            i1 = "{ call insert_Movie(?) }",
            i2 = "{ call insert_Movie(?,?) }",
            i3 = "{ call insert_Movie(?,?,?) }",
            i4 = "{ call insert_Movie(?,?,?,?) }",
            i5 = "{ call insert_Movie(?,?,?,?,?) }",
            i6 = "{ call insert_Movie(?,?,?,?,?,?) }",
            i7 = "{ call insert_Movie(?,?,?,?,?,?,?) }";
}
