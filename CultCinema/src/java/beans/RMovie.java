/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.sqlColumnName.MovieColumn;

/**
 *
 * @author 52593578
 */
public class RMovie {
    private String language;
    private String movie_id;
    private String movie_name;
    private String movie_author;
    private String movie_description;
    private String movie_startDate;
    private String movie_endDate;
//--------------------------------------------------------------------------
    public RMovie() {
        language = "";
        movie_id = "";
        movie_name = "";
        movie_author = "";
        movie_description = "";
        movie_startDate = "";
        movie_endDate = "";
    }
//--------------------------------------------------------------------------
    public void setLanguage(String in) {
        set(MovieColumn.LANGUAGE, in);
    }
    public void setMovieID(String in) {
        set(MovieColumn.MOVIE_ID, in);
    }
    public void setMovieName(String in) {
        set(MovieColumn.MOVIE_NAME, in);
    }
    public void setMovieAuthor(String in) {
        set(MovieColumn.MOVIE_AUTHOR, in);
    }
    public void setMovieDescription(String in) {
        set(MovieColumn.MOVIE_DESCRIPTION, in);
    }
    public void setMovieStartDate(String in) {
        set(MovieColumn.MOVIE_STARTDATE, in);
    }
    public void setMovieEndDate(String in) {
        set(MovieColumn.MOVIE_ENDDATE, in);
    }
    private void set(String d, String in) {
        if (d == MovieColumn.LANGUAGE)
            language = in;
        else if (d == MovieColumn.MOVIE_ID)
            movie_id = in;
        else if (d == MovieColumn.MOVIE_NAME)
            movie_name = in;
        else if (d == MovieColumn.MOVIE_AUTHOR)
            movie_author = in;
        else if (d == MovieColumn.MOVIE_DESCRIPTION)
            movie_description = in;
        else if (d == MovieColumn.MOVIE_STARTDATE)
            movie_startDate = in;
        else if (d == MovieColumn.MOVIE_ENDDATE)
            movie_endDate = in;
    }
//----------------------------------------------------------------------------
    public String getLanguage() {
        return get(MovieColumn.LANGUAGE);
    }
    public String getMovieID() {
        return get(MovieColumn.MOVIE_ID);
    }
    public String getMovieName() {
        return get(MovieColumn.MOVIE_NAME);
    }
    public String getMovieAuthor() {
        return get(MovieColumn.MOVIE_AUTHOR);
    }
    public String getMovieDescription() {
        return get(MovieColumn.MOVIE_DESCRIPTION);
    }
    public String getMovieStartDate() {
        return get(MovieColumn.MOVIE_STARTDATE);
    }
    public String getMovieEndDate() {
        return get(MovieColumn.MOVIE_ENDDATE);
    }
    private String get(String d) {
        if (d == MovieColumn.LANGUAGE)
            return language;
        else if (d == MovieColumn.MOVIE_ID)
            return movie_id;
        else if (d == MovieColumn.MOVIE_NAME)
            return movie_name;
        else if (d == MovieColumn.MOVIE_AUTHOR)
            return movie_author;
        else if (d == MovieColumn.MOVIE_DESCRIPTION)
            return movie_description;
        else if (d == MovieColumn.MOVIE_STARTDATE)
            return movie_startDate;
        else if (d == MovieColumn.MOVIE_ENDDATE)
            return movie_endDate;
        else
            return "";
    }
}
