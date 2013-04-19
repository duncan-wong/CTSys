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
        set(MovieShowColumn.HOUSE_ID, in);
    }
    public void setShowingID(String in) {
        set(MovieShowColumn.SHOWING_ID, in);
    }
    public void setMovieID(String in) {
        set(MovieShowColumn.MOVIE_ID, in);
    }
    public void setShowingStartDate(String in) {
        set(MovieShowColumn.SHOWING_STARTDATE, in);
    }
    public void setShowingStartTime(String in) {
        set(MovieShowColumn.SHOWING_STARTTIME, in);
    }
    public void setShowingEndDate(String in) {
        set(MovieShowColumn.SHOWING_ENDDATE, in);
    }
    public void setShowingEndTime(String in) {
        set(MovieShowColumn.SHOWING_ENDTIME, in);
    }
    public void setTicketPrice(String in) {
        set(MovieShowColumn.TICKET_PRICE, in);
    }
    private void set(String id, String in) {
        if (id == MovieShowColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == MovieShowColumn.SHOWING_ID) {
            showing_id = in;
        }
        else if (id == MovieShowColumn.MOVIE_ID) {
            movie_id = in;
        }
        else if (id == MovieShowColumn.SHOWING_STARTDATE) {
            showing_startDate = in;
        }
        else if (id == MovieShowColumn.SHOWING_STARTTIME) {
            showing_startTime = in;
        }
        else if (id == MovieShowColumn.SHOWING_ENDDATE) {
            showing_endDate = in;
        }
        else if (id == MovieShowColumn.SHOWING_ENDTIME) {
            showing_endTime = in;
        }
        else if (id == MovieShowColumn.TICKET_PRICE) {
            ticket_price = in;
        }
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public String getHouseID() {
        return house_id;
    }
    public String getShowingID() {
        return showing_id;
    }
    public String getMovieID() {
        return movie_id;
    }
    public String getShowingStartDate() {
        return showing_startDate;
    }
    public String getShowingStartTime() {
        return showing_startTime;
    }
    public String getShowingEndDate() {
        return showing_endDate;
    }
    public String getShowingEndTime() {
        return showing_endTime;
    }
    public String getTicketPrice() {
        return ticket_price;
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
            DBconnect db = new DBconnect(MovieShowSQL.i4);
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
            DBconnect db = new DBconnect(MovieShowSQL.u5);
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
            DBconnect db = new DBconnect(MovieShowSQL.d1);
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
