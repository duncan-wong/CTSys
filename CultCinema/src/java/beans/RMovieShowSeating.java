/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.HouseSQL;
import beans.sql.ShowSeatingSQL;
import beans.sqlColumnName.SeatColumn;
import beans.sqlColumnName.ShowSeatingColumn;
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
public class RMovieShowSeating extends UpdatableBean {
    private String showing_id;
    private String house_id;
    private ArrayList<Integer> rowMax;
    private RSeat[][] seating;
//-----------------------------------------------------------------------------
    public RMovieShowSeating() {
        super();
        house_id = null;
        showing_id = null;
        rowMax = new ArrayList<Integer>();
    }
//-----------------------------------------------------------------------------
    public void setHouseID(String in) {
        
    }
    public void setShowingID(String in) {
        
    }
    private void set(String id, String in) {
        if (id == ShowSeatingColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == ShowSeatingColumn.SHOWING_ID) {
            showing_id = in;
        }
        this.setChangedTrue();
    }
    // if the customer want this seat, insert his booking_id
    public void makeBooking(String booking_id, int row, int seat) {
        seating[row][seat].setBookingID(booking_id);
    }
    // if the customer don't want this seat, remove his booking_id
    public void setSeatToEmpty(int row, int seat) {
        seating[row][seat].setEmpty();
    }
//-----------------------------------------------------------------------------
    public String getHouseID() {
        return house_id;
    }
    public String getShowingID() {
        return showing_id;
    }
    // return true if the seat is booked
    public boolean getSeatStatus(int row, int seat) {
        return seating[row][seat].isBooked();
    }
    public int getNumOfBookedSeat() {
        int count = 0;
        for (int i=0; i<seating.length; i++) {
            for (int j=0; j<seating[i].length; j++) {
                if (seating[i][j].isBooked()) {
                    count++;
                }
            }
        }
        return count;
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        ArrayList<RSeat> b = new ArrayList<RSeat>();
        RSeat t;
        int bc = 0;
        int row;
        try {
            DBconnect db = new DBconnect(ShowSeatingSQL.s1);
            db.setXxx(1, showing_id);
            db.executeQuery();
            while (db.queryHasNext()) {
                t = new RSeat();
                t.setRowNum(db.getXxx(SeatColumn.ROW_NUMBER, 0));
                t.setSeatNum(db.getXxx(SeatColumn.SEAT_NUMBER, 0));
                b.add(t);
            }
            db.disconnect();
            /**
            db.prepareCall(ShowSeatingSQL.s2_seatPlan);
            db.setXxx(1, null);
            db.setXxx(2, showing_id);
            if (db.queryHasNext()) {
                row = db.getXxx(, row)
            }
            while (db.queryHasNext()) {
                row
            }
            */
            db.disconnect();
        } catch (NamingException ex) {
            Logger.getLogger(RMovieShowSeating.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieShowSeating.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
