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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author A
 */
public class RMovieShow extends UpdatableBean {
    private String house_id;
    private String showing_id;
    private String movie_id;
    private String showing_startDate;
    private String showing_startTime;
    private String showing_endDate;
    private String showing_endTime;
    private String ticket_price;
//-----------------------------------------------------------------------------
    public RMovieShow() {
        super();
        house_id = null;
        showing_id = null;
        movie_id = null;
        showing_startDate = null;
        showing_startTime = null;
        showing_endDate = null;
        showing_endTime = null;
        ticket_price = null;
    }
//-----------------------------------------------------------------------------
    public void setHouseID(String in) {
        set(ShowingColumn.HOUSE_ID, in);
    }
    public void setShowingID(String in) {
        set(ShowingColumn.SHOWING_ID, in);
    }
    public void setMovieID(String in) {
        set(ShowingColumn.MOVIE_ID, in);
    }
    public void setShowingStartDate(String in) {
        set(ShowingColumn.SHOWING_STARTDATE, in);
    }
    public void setShowingStartTime(String in) {
        set(ShowingColumn.SHOWING_STARTTIME, in);
    }
    public void setShowingEndDate(String in) {
        set(ShowingColumn.SHOWING_ENDDATE, in);
    }
    public void setShowingEndTime(String in) {
        set(ShowingColumn.SHOWING_ENDTIME, in);
    }
    public void setTicketPrice(String in) {
        set(ShowingColumn.TICKET_PRICE, in);
    }
    private void set(String id, String in) {
        if (id == ShowingColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == ShowingColumn.SHOWING_ID) {
            showing_id = in;
        }
        else if (id == ShowingColumn.MOVIE_ID) {
            movie_id = in;
        }
        else if (id == ShowingColumn.SHOWING_STARTDATE) {
            showing_startDate = in;
        }
        else if (id == ShowingColumn.SHOWING_STARTTIME) {
            showing_startTime = in;
        }
        else if (id == ShowingColumn.SHOWING_ENDDATE) {
            showing_endDate = in;
        }
        else if (id == ShowingColumn.SHOWING_ENDTIME) {
            showing_endTime = in;
        }
        else if (id == ShowingColumn.TICKET_PRICE) {
            ticket_price = in;
        }
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public String getHouseID() {
        return get(ShowingColumn.HOUSE_ID);
    }
    public String getShowingID() {
        return get(ShowingColumn.SHOWING_ID);
    }
    public String getMovieID() {
        return get(ShowingColumn.MOVIE_ID);
    }
    public String getShowingStartDate() {
        return get(ShowingColumn.SHOWING_STARTDATE);
    }
    public String getShowingStartTime() {
        return get(ShowingColumn.SHOWING_STARTTIME);
    }
    public String getShowingEndDate() {
        return get(ShowingColumn.SHOWING_ENDDATE);
    }
    public String getShowingEndTime() {
        return get(ShowingColumn.SHOWING_ENDTIME);
    }
    public String getTicketPrice() {
        return get(ShowingColumn.TICKET_PRICE);
    }
    private String get(String id) {
        if (id == ShowingColumn.HOUSE_ID) {
            return house_id;
        }
        else if (id == ShowingColumn.SHOWING_ID) {
            return showing_id;
        }
        else if (id == ShowingColumn.MOVIE_ID) {
            return movie_id;
        }
        else if (id == ShowingColumn.SHOWING_STARTDATE) {
            return showing_startDate;
        }
        else if (id == ShowingColumn.SHOWING_STARTTIME) {
            return showing_startTime;
        }
        else if (id == ShowingColumn.SHOWING_ENDDATE) {
            return showing_endDate;
        }
        else if (id == ShowingColumn.SHOWING_ENDTIME) {
            return showing_endTime;
        }
        else if (id == ShowingColumn.TICKET_PRICE) {
            return ticket_price;
        }
        return "";
    }
//-----------------------------------------------------------------------------
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
            DBconnect db = new DBconnect(ShowingSQL.i4);
            db.setResult();
            db.setXxx(2, house_id);
            db.setXxx(3, movie_id);
            db.setXxx(4, showing_startDate +" "+ showing_startTime);
            db.setXxx(5, ticket_price);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(ShowingSQL.u5);
            db.setResult();
            db.setXxx(2, showing_id);
            db.setXxx(3, house_id);
            db.setXxx(4, movie_id);
            db.setXxx(5, showing_startDate +" "+ showing_startTime);
            db.setXxx(6, ticket_price);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean commitDelete() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(ShowingSQL.d1);
            db.setResult();
            db.setXxx(2, showing_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
