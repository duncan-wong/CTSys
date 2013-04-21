/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.*;
import beans.sql.MovieSQL;
import beans.sqlColumnName.MovieColumn;
import common.jdbc.DBconnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author 52593578
 */
public class RMovie extends UpdatableBean {
    private String language;
    private String movie_id;
    private String movie_name;
    private String movie_author;
    private String movie_description;
    private String movie_duration;
    private String movie_startDate;
    private String movie_endDate;
//--------------------------------------------------------------------------
    public RMovie() {
        super();
        language = null;
        movie_id = null;
        movie_name = null;
        movie_author = null;
        movie_description = null;
        movie_duration = null;
        movie_startDate = null;
        movie_endDate = null;
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
    public void setMovieDuration(String in) {
        set(MovieColumn.MOVIE_DURATION, in);
    }
    public void setMovieStartDate(String in) {
        set(MovieColumn.MOVIE_STARTDATE, in);
    }
    public void setMovieEndDate(String in) {
        set(MovieColumn.MOVIE_ENDDATE, in);
    }
    private void set(String d, String in) {
        if (d == MovieColumn.LANGUAGE) {
            language = in;
        }
        else if (d == MovieColumn.MOVIE_ID) {
            movie_id = in;
        }
        else if (d == MovieColumn.MOVIE_NAME) {
            movie_name = in;
        }
        else if (d == MovieColumn.MOVIE_AUTHOR) {
            movie_author = in;
        }
        else if (d == MovieColumn.MOVIE_DESCRIPTION) {
            movie_description = in;
        }
        else if (d == MovieColumn.MOVIE_DURATION) {
            movie_duration = in;
        }
        else if (d == MovieColumn.MOVIE_STARTDATE) {
            movie_startDate = in;
        }
        else if (d == MovieColumn.MOVIE_ENDDATE) {
            movie_endDate = in;
        }
        this.setChangedTrue();
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
    public String getMovieDuration() {
        return get(MovieColumn.MOVIE_DURATION);
    }
    public String getMovieStartDate() {
        return get(MovieColumn.MOVIE_STARTDATE);
    }
    public String getMovieEndDate() {
        return get(MovieColumn.MOVIE_ENDDATE);
    }
    private String get(String d) {
        if (d == MovieColumn.LANGUAGE) {
            return language;
        }
        else if (d == MovieColumn.MOVIE_ID) {
            return movie_id;
        }
        else if (d == MovieColumn.MOVIE_NAME) {
            return movie_name;
        }
        else if (d == MovieColumn.MOVIE_AUTHOR) {
            return movie_author;
        }
        else if (d == MovieColumn.MOVIE_DESCRIPTION) {
            return movie_description;
        }
        else if (d == MovieColumn.MOVIE_DURATION) {
            return movie_duration;
        }
        else if (d == MovieColumn.MOVIE_STARTDATE) {
            return movie_startDate;
        }
        else if (d == MovieColumn.MOVIE_ENDDATE) {
            return movie_endDate;
        }
        return "";
    }
//----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect(MovieSQL.s5);
            db.setXxx(1, language);
            db.setXxx(2, movie_id);
            db.setXxx(3, null);
            db.setXxx(4, null);
            db.setXxx(5, null);
            db.executeQuery();
            if (db.queryHasNext()) {
                language = db.getXxx(MovieColumn.LANGUAGE);
                movie_name = db.getXxx(MovieColumn.MOVIE_NAME);
                movie_author = db.getXxx(MovieColumn.MOVIE_AUTHOR);
                movie_description = db.getXxx(MovieColumn.MOVIE_DESCRIPTION);
                movie_duration = db.getXxx(MovieColumn.MOVIE_DURATION);
                movie_startDate = db.getXxx(MovieColumn.MOVIE_STARTDATE);
                movie_endDate = db.getXxx(MovieColumn.MOVIE_ENDDATE);
            }
            else{
                return false;
            }
            db.disconnect();
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RMovieCol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieCol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean commitChange() {
        super.commitChange();
        if (this.isNew()) {
            return commitInsert();
        }
        else if (this.isChanged()) {
            return commitUpdate();
        }
        return true;
    }
    
    
    public boolean commitInsert() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(MovieSQL.i6);
            db.setResult();
            db.setXxx(2, movie_name);
            db.setXxx(3, movie_author);
            db.setXxx(4, movie_description);
            db.setXxx(5, movie_startDate);
            db.setXxx(6, movie_endDate);
            db.setXxx(7, movie_duration);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(MovieSQL.u8);
            db.setResult();
            db.setXxx(2, language);
            db.setXxx(3, movie_id);
            db.setXxx(4, movie_name);
            db.setXxx(5, movie_author);
            db.setXxx(6, movie_description);
            db.setXxx(7, movie_duration);
            db.setXxx(8, movie_startDate);
            db.setXxx(9, movie_endDate);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean commitDelete() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(MovieSQL.d1);
            db.setResult();
            db.setXxx(2, movie_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
