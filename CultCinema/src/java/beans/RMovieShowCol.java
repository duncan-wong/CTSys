/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.ShowingSQL;
import beans.sqlColumnName.ShowingColumn;
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
    private String search_dayBefore; // ( Default 365 days )
    private String search_timeAfter; // ( Default : now )
    private String search_houseID;
    private String search_movieID;
    private String search_language;  // ( Default is 'en' )
    private ArrayList<RMovieShow> showingCol;
    private ArrayList<RMovieShow> showingWaitForDelete;
//-----------------------------------------------------------------------------
    public RMovieShowCol() {
        super();
        resetSearch();
        showingCol = new ArrayList<RMovieShow>();
        showingWaitForDelete = new ArrayList<RMovieShow>();
    }
    public void searchDay(String day) {
        this.search_dayBefore = day;
    }
    public void setTime(String time) {
        this.search_timeAfter = time;
    }
    public void setHouseID(String house_id) {
        this.search_houseID = house_id;
    }
    public void setMovieID(String movie_id) {
        this.search_movieID = movie_id;
    }
    public void setLanguage(String language) {
        this.search_language = language;
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
    public void searchDayBefore(String in) {
        search_dayBefore = in;
    }
    public void searchTimeAfter(String in) {
        search_timeAfter = in;
    }
    public void resetSearch() {
        search_dayBefore = null;
        search_timeAfter = null;
        search_houseID = null;
        search_movieID = null;
        search_language = null;
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        super.fetchDBData();
        showingCol.clear();
        try {
            DBconnect db = new DBconnect(ShowingSQL.s5);
            db.setXxx(1, search_dayBefore);
            db.setXxx(2, search_timeAfter);
            db.setXxx(3, search_houseID);
            db.setXxx(4, search_movieID);
            db.setXxx(5, search_language);
            db.executeQuery();
            while (db.queryHasNext()) {
                RMovieShow r = new RMovieShow();
                r.setHouseID(db.getXxx(ShowingColumn.HOUSE_ID));
                r.setMovieID(db.getXxx(ShowingColumn.MOVIE_ID));
                r.setShowingEndDate(db.getXxx(ShowingColumn.SHOWING_ENDDATE));
                r.setShowingEndTime(db.getXxx(ShowingColumn.SHOWING_ENDTIME));
                r.setShowingID(db.getXxx(ShowingColumn.SHOWING_ID));
                r.setShowingStartDate(db.getXxx(ShowingColumn.SHOWING_STARTDATE));
                r.setShowingStartTime(db.getXxx(ShowingColumn.SHOWING_STARTTIME));
                r.setTicketPrice(db.getXxx(ShowingColumn.TICKET_PRICE));
                showingCol.add(r);
            }
            db.disconnect();
            return true;
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
        return false;
    }
}