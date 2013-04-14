/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 52593578
 */
public class RMovie {
    public static enum data {
        LANGUAGE,
        MOVIE_ID,
        MOVIE_NAME,
        MOVIE_AUTHOR,
        MOVIE_DESCRIPTION,
        MOVIE_STARTDATE,
        MOVIE_ENDDATE
    }
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
    public void set(data d, String in) {
        switch (d) {
            case LANGUAGE:
                language = in; break;
            case MOVIE_ID:
                movie_id = in; break;
            case MOVIE_NAME:
                movie_name = in; break;
            case MOVIE_AUTHOR:
                movie_author = in; break;
            case MOVIE_DESCRIPTION:
                movie_description = in; break;
            case MOVIE_STARTDATE:
                movie_startDate = in; break;
            case MOVIE_ENDDATE:
                movie_endDate = in; break;
        }       
    }
    public String get(data d) {
        switch (d) {
            case LANGUAGE:
                return language;
            case MOVIE_ID:
                return movie_id;
            case MOVIE_NAME:
                return movie_name;
            case MOVIE_AUTHOR:
                return movie_author;
            case MOVIE_DESCRIPTION:
                return movie_description;
            case MOVIE_STARTDATE:
                return movie_startDate;
            case MOVIE_ENDDATE:
                return movie_endDate;
            default:
                return "";
        }       
    }
}
