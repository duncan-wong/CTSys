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
    public static final String S0 = "{ call show_Movie }";
    public static final String S1 = "{ call show_Movie(?) }";
    public static final String S2 = "{ call show_Movie(?,?) }";
    public static final String S3 = "{ call show_Movie(?,?,?) }";
    public static final String S4 = "{ call show_Movie(?,?,?,?) }";
    public static final String S5 = "{ call show_Movie(?,?,?,?,?) }";
}
