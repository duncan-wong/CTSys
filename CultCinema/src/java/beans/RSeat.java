/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.SeatSQL;
import beans.sqlColumnName.SeatColumn;
import common.jdbc.DBconnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author A
 */
public class RSeat extends UpdatableBean {
    private String house_id;
    private String active;
    private String row_number;
    private String seat_number;
    private String booking_id;
    private String showing_id;
//-----------------------------------------------------------------------------
    public RSeat() {
        super();
        house_id = null;
        row_number = null;
        seat_number = null;
        active = null;
        showing_id = null;
        booking_id = null;
    }
    public RSeat(String house_id) {
        this();
        this.house_id = house_id;
    }
//-----------------------------------------------------------------------------
    public void setHouseID(String in) {
        set(SeatColumn.HOUSE_ID, in);
    }
    public void setRowNum(int in) {
        set(SeatColumn.ROW_NUMBER, Integer.toString(in));
    }
    public void setSeatNum(int in) {
        set(SeatColumn.SEAT_NUMBER, Integer.toString(in));
    }
    public void setActiveStatus(int in) {
        set(SeatColumn.ACTIVE, Integer.toString(in));
    }
    public void setBookingID(String in) {
        set(SeatColumn.BOOKING_ID, in);
    }
    public void setMovieShowID(String in) {
        set(SeatColumn.SHOWING_ID, in);
    }
    private void set(String id, String in) {
        if (id == SeatColumn.ROW_NUMBER) {
            row_number = in;
        }
        else if (id == SeatColumn.SEAT_NUMBER) {
            seat_number = in;
        }
        else if (id == SeatColumn.ACTIVE) {
            active = in;
        }
        else if (id == SeatColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == SeatColumn.BOOKING_ID) {
            booking_id = in;
        }
        else if (id == SeatColumn.SHOWING_ID) {
            showing_id = in;
        }
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public int getRowNum() {
        return Integer.parseInt(row_number);
    }
    public int getSeatNum() {
        return Integer.parseInt(seat_number);
    }
    public boolean isActive_Seat() {
        if (active == "1") {
            return true;
        }
        return false;
    }
    public boolean isDisable_Ticket() {
        if (booking_id == "Disable") {
            return true;
        }
        return false;
    }
    public boolean isBooked() {
        if (booking_id == "--") {
            return false;
        }
        return true;
    }
    public String getRowID() {
        char c = (char) ('A' + Integer.parseInt(row_number) - 1);
        return "" + c;
    }
    public String getSeatID() {
        return getRowID() + String.format("%02d", Integer.parseInt(seat_number));
    }
    public String getTicketID() {
        return String.format("%06d", Integer.parseInt(showing_id)) + "-" + getSeatID();
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean commitChange() {
        super.commitChange();
        if (booking_id != null) {
            if (this.isChanged()) {
                return commitInsert_Ticket();
            }
        }
        else {
            if (this.isChanged()) {
                return commitUpdate_Seat();
            }
        }
        return true;
    }
    
    // for movie show ticket use
    public boolean commitInsert_Ticket() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(SeatSQL.i4_Showing);
            db.setResult();
            db.setXxx(2, showing_id);
            db.setXxx(3, row_number);
            db.setXxx(4, seat_number);
            db.setXxx(5, booking_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RSeat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RSeat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // for house seat
    public boolean commitUpdate_Seat() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(SeatSQL.u4_House);
            db.setResult();
            db.setXxx(2, house_id);
            db.setXxx(3, row_number);
            db.setXxx(4, seat_number);
            db.setXxx(5, active);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RSeat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RSeat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
