/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.Bean;
import common.jdbc.DBconnect;
import beans.sqlColumnName.MovieColumn;
import beans.sql.MovieSQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author DUNCAN
 */


//collection of RMovie objects
public class RMovieCol implements Bean {
    private ArrayList<RMovie> movieCol;
    private String search_Language;
    private String search_ID;
    private String search_Name;
    private String search_Author;
    private String order;
//-----------------------------------------------------------------------------
    public RMovieCol() {
        search_Language = null;
        search_ID = null;
        search_Name = null;
        search_Author = null;
        order = null;
        fetchDBData();
    }
//-----------------------------------------------------------------------------
    private void add(RMovie r) {
        movieCol.add(r);
    }
//-----------------------------------------------------------------------------
    public RMovie[] getAll() {
        return movieCol.toArray(new RMovie[movieCol.size()]);
    }
    public RMovie getAt(int i) {
        return movieCol.get(i);
    }
    public int count() {
        return movieCol.size();
    }
    public void changeLang(String in) {
        search_Language = in;
        fetchDBData();
    }
    public void searchMovieID(String in) {
        search_ID = in;
        fetchDBData();
    }
    public void searchMovieName(String in) {
        search_Name = in;
        fetchDBData();
    }
    public void searchMovieAuthor(String in) {
        search_Author = in;
        fetchDBData();
    }
    public void changeOrder(String in) {
        order = in;
        fetchDBData();
    }
//-----------------------------------------------------------------------------
    public boolean fetchDBData() {
        movieCol = new ArrayList<RMovie>();
        try {
            DBconnect db = new DBconnect(MovieSQL.S5);
            db.setXxx(1, search_Language);
            db.setXxx(2, search_ID);
            db.setXxx(3, search_Name);
            db.setXxx(4, search_Author);
            db.setXxx(5, order);
            db.executeQuery();
            while (db.queryHasNext()) {
                RMovie r = new RMovie();
                r.setLanguage(db.getXxx(MovieColumn.LANGUAGE));
                r.setMovieID(db.getXxx(MovieColumn.MOVIE_ID));
                r.setMovieName(db.getXxx(MovieColumn.MOVIE_NAME));
                r.setMovieAuthor(db.getXxx(MovieColumn.MOVIE_AUTHOR));
                r.setMovieDescription(db.getXxx(MovieColumn.MOVIE_DESCRIPTION));
                r.setMovieDuration(db.getXxx(MovieColumn.MOVIE_DURATION));
                r.setMovieStartDate(db.getXxx(MovieColumn.MOVIE_STARTDATE));
                r.setMovieEndDate(db.getXxx(MovieColumn.MOVIE_ENDDATE));
                movieCol.add(r);
            }
            db.disconnect();
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(RMovieCol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieCol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean commitChange() {
        int recordAffected = 0;
        for (int i=0; i<count(); i++) {
            recordAffected = movieCol.get(i).commitChange();
            if (recordAffected == -1)
                return false;
        }
        return true;
    }
}