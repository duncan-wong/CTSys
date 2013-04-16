/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.*;
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
public class RMovieCol extends UpdatableBean{
    private ArrayList<RMovie> movieCol;
    private ArrayList<RMovie> movieWaitForDelete;
    private String search_Language;
    private String search_ID;
    private String search_Name;
    private String search_Author;
    private String order;
//-----------------------------------------------------------------------------
    public RMovieCol() {
        super();
        resetSearch();
        movieCol = new ArrayList<RMovie>();
        movieWaitForDelete = new ArrayList<RMovie>();
    }
//-----------------------------------------------------------------------------
    private void add(RMovie r) {
        this.setChangedTrue();
        movieCol.add(r);
    }
    public void addMovie(RMovie r) {
        this.setChangedTrue();
        movieCol.add(r);
    }
    public void deleteMovie(RMovie r) {
        this.setChangedTrue();
        movieCol.remove(r);
        movieWaitForDelete.add(r);
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
    }
    public void searchMovieID(String in) {
        search_ID = in;
    }
    public void searchMovieName(String in) {
        search_Name = in;
    }
    public void searchMovieAuthor(String in) {
        search_Author = in;
    }
    public void changeOrder(String in) {
        order = in;
    }
    public void resetSearch() {
        search_Language = null;
        search_ID = null;
        search_Name = null;
        search_Author = null;
        order = null;
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        super.fetchDBData();
        movieCol.clear();
        try {
            DBconnect db = new DBconnect(MovieSQL.s5);
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

    @Override
    public boolean commitChange() {
        super.commitChange();
        boolean isOld;
        for (int i=0; i<movieCol.size(); i++) {
            isOld = movieCol.contains(movieCol.get(i));
            if (!movieCol.get(i).commitChange()) {
                return false;
            }
        }
        for (int i=0; i<movieWaitForDelete.size(); i++) {
            if (!movieWaitForDelete.get(i).commitDelete()) {
                return false;
            }
        }
        movieWaitForDelete.clear();
        return true;
    }
    
    
}