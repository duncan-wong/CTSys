/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.HouseSQL;
import beans.sqlColumnName.HouseColumn;
import beans.sqlColumnName.SeatColumn;
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
public class RHouse extends UpdatableBean {
    private String house_id;
    private String house_name;
    private String house_capacity;
    private String total_row;
    private RSeat[][] seats;
//------------------------------------------------------------------------------
    public RHouse() {
        super();
        house_id = null;
        house_name = null;
        house_capacity = null;
        total_row = null;
        seats = null;
    }
//------------------------------------------------------------------------------
    public void setHouseID(String in) {
        set(HouseColumn.HOUSE_ID, in);
    }
    public void setHouseName(String in) {
        set(HouseColumn.HOUSE_NAME, in);
    }
    public void setHouseCapacity(int in) {
        set(HouseColumn.HOUSE_CAPACITYU, Integer.toString(in));
    }
    public void setTotalRow(int in) {
        set(HouseColumn.TOTAL_ROW, Integer.toString(in));
    }
    private void set(String id, String in) {
        if (id == HouseColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == HouseColumn.HOUSE_NAME) {
            house_name = in;
        }
        else if (id == HouseColumn.HOUSE_CAPACITYU) {
            house_capacity = in;
        }
        else if (id == HouseColumn.TOTAL_ROW) {
            total_row = in;
        }
        this.setChangedTrue();
    }
//------------------------------------------------------------------------------
    public String getHouseID() {
        return house_id;
    }
    public String getHouseName() {
        return house_name;
    }
    public int getHouseCapacity() {
        return Integer.parseInt(house_capacity);
    }
    public int getTotalRow() {
        return Integer.parseInt(total_row);
    }
    public RSeat getSeatAt(int row, int seat) {
        return seats[row][seat];
    }
    public RSeat[][] getAllSeat() {
        return seats;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect(HouseSQL.s1);
            db.setXxx(1, house_id);
            db.executeQuery();
            if (db.queryHasNext()) {
                house_name = db.getXxx(HouseColumn.HOUSE_NAME);
                house_capacity = db.getXxx(HouseColumn.HOUSE_CAPACITYU);
                total_row = db.getXxx(HouseColumn.TOTAL_ROW);
            }
            db.disconnect();
            // get the seats
            db = new DBconnect(HouseSQL.s1_Seat);
            db.setXxx(1, house_id);
            db.executeQuery();
            seats = new RSeat[Integer.parseInt(total_row)][];
            ArrayList<RSeat> oneRow = new ArrayList<RSeat>();
            int rowCount = 1;
            RSeat rsTemp;
            while (db.queryHasNext()) {
                rsTemp = new RSeat(house_id);
                if (rowCount + 1 == db.getXxx(SeatColumn.ROW_NUMBER, 0)) {
                    seats[rowCount-1] = oneRow.toArray(new RSeat[oneRow.size()]);
                    rowCount++;
                    oneRow.clear();
                }
                rsTemp.setRowNum(db.getXxx(SeatColumn.ROW_NUMBER, 0));
                rsTemp.setSeatNum(db.getXxx(SeatColumn.SEAT_NUMBER, 0));
                rsTemp.setActiveStatus(db.getXxx(SeatColumn.ACTIVE, 0));
                rsTemp.afterInitialization();
                oneRow.add(rsTemp);
            }
            seats[rowCount-1] = oneRow.toArray(new RSeat[oneRow.size()]);
            db.disconnect();
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    @Override
    public boolean commitChange() {
        super.commitChange();
        for (int i=0; i<seats.length; i++) {
            for (int j=0; j<seats[i].length; j++) {
                if (!seats[i][j].commitChange()) {
                    return false;
                }
            }
        }
        if (this.isChanged()) {
            // only allowed to update the house_name only
            return commitUpdate();
        }
        else if (this.isNew()) {
            return commitInsert();
        }
        return true;
    }
    
    // clear the seating plan of the house
    // not in commitChange()
    public boolean commitClear() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(HouseSQL.d1_Seat);
            db.setResult();
            db.setXxx(2, house_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // soft delete the house
    public boolean commitDelete() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(HouseSQL.d1);
            db.setResult();
            db.setXxx(2, house_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**********
     * CASE 1: if house_id is NULL.
     *   Mean: insert a new house, house_name
     * 
     * CASE 2: if house_id is not NULL 
     *         && house_name is NULL.
     *   Mean: insert a new seating plan
     * 
     */
    public boolean commitInsert() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(HouseSQL.i4);
            db.setResult();
            db.setXxx(2, house_name);
            db.setXxx(3, house_capacity);
            db.setXxx(4, total_row);
            db.setXxx(5, house_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // update only the house_name
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(HouseSQL.u2);
            db.setResult();
            db.setXxx(2, house_id);
            db.setXxx(3, house_name);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
            return super.fetchDBData();
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
