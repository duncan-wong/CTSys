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
    private String row_number;
    private String seat_number;
    private String active;
//-----------------------------------------------------------------------------
    public RSeat() {
        house_id = null;
        row_number = null;
        seat_number = null;
        active = null;
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
    public void set(String id, String in) {
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
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public int getRowNum() {
        return Integer.parseInt(row_number);
    }
    public int getSeatNum() {
        return Integer.parseInt(seat_number);
    }
    public int getActiveStatus() {
        return Integer.parseInt(active);
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean commitChange() {
        super.commitChange();
        if (this.isChanged()) {
            return commitUpdate();
        }
        return true;
    }
    
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(SeatSQL.u4);
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
