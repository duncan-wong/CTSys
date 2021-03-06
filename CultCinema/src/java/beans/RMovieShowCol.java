/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.MovieShowSQL;
import beans.sqlColumnName.MovieShowColumn;
import common.jdbc.DBconnect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author A
 */
public class RMovieShowCol extends UpdatableBean {
    private String search_dayRange;  // ( Default 0 )
    private String search_timeAfter; // ( Default : now )
    private String search_houseID;
    private String search_movieID;
    private String search_language;  // ( Default is 'en' )
    private String search_movieShowID;
    private ArrayList<RMovieShow> showingCol;
    private ArrayList<RMovieShow> showingWaitForDelete;
//-----------------------------------------------------------------------------
    public RMovieShowCol() {
        super();
        resetSearch();
        showingCol = new ArrayList<RMovieShow>();
        showingWaitForDelete = new ArrayList<RMovieShow>();
    }
//-----------------------------------------------------------------------------
    public void addShowing(RMovieShow r) {
        this.setChangedTrue();
        showingCol.add(r);
    }
    public void deleteShowing(RMovieShow r) {
        this.setChangedTrue();
        showingCol.remove(r);
        showingWaitForDelete.add(r);
    }
//-----------------------------------------------------------------------------
    public RMovieShow[] getAll() {
        return showingCol.toArray(new RMovieShow[showingCol.size()]);
    }
    public RMovieShow getAt(int id) {
        return showingCol.get(id);
    }
    public int count() {
        return showingCol.size();
    }
    public void changeLang(String in) {
        search_language = in;
    }
    public void searchMovieID(String in) {
        search_movieID = in;
    }
    public void searchHouseID(String in) {
        search_houseID = in;
    }
    public void searchTimeAfter(String in) {
        search_timeAfter = in;
    }
    public void searchInDayRange(int in) {
        search_dayRange = String.valueOf(in);
    }
    public void searchMovieShowID(String in) {
        search_movieShowID = in;
    }
    public void resetSearch() {
        search_dayRange = null;
        search_timeAfter = null;
        search_houseID = null;
        search_movieID = null;
        search_language = null;
        search_movieShowID = null;
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        showingCol.clear();
        try {
            DBconnect db = new DBconnect(MovieShowSQL.s6);
            db.setXxx(1, search_dayRange);
            db.setXxx(2, search_timeAfter);
            db.setXxx(3, search_houseID);
            db.setXxx(4, search_movieID);
            db.setXxx(5, search_language);
            db.setXxx(6, search_movieShowID);
            db.executeQuery();
            while (db.queryHasNext()) {
                RMovieShow r = new RMovieShow();
                r.setHouseID(db.getXxx(MovieShowColumn.HOUSE_ID));
                r.setMovieID(db.getXxx(MovieShowColumn.MOVIE_ID));
                r.setMovieShowEndDate(db.getXxx(MovieShowColumn.SHOWING_ENDDATE));
                r.setMovieShowEndTime(db.getXxx(MovieShowColumn.SHOWING_ENDTIME));
                r.setMovieShowID(db.getXxx(MovieShowColumn.SHOWING_ID));
                r.setMovieShowStartDate(db.getXxx(MovieShowColumn.SHOWING_STARTDATE));
                r.setMovieShowStartTime(db.getXxx(MovieShowColumn.SHOWING_STARTTIME));
                r.setTicketPrice(db.getXxx(MovieShowColumn.TICKET_PRICE));
                r.afterInitialization();
                showingCol.add(r);
            }
            db.disconnect();
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RMovieShowCol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieShowCol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean commitChange() {
        super.commitChange();
        for (int i=0; i<showingCol.size(); i++) {
            if (!showingCol.get(i).commitChange())
                return false;
        }
        for (int i=0; i<showingWaitForDelete.size(); i++) {
            if (!showingWaitForDelete.get(i).commitDelete()) {
                return false;
            }
        }
        showingWaitForDelete.clear();
        return true;
    }
}
