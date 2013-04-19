/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.HouseSQL;
import beans.sqlColumnName.HouseColumn;
import common.jdbc.DBconnect;
import java.sql.SQLException;
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
    private String row_count;
//-----------------------------------------------------------------------------
    public RHouse() {
        house_id = null;
        house_name = null;
        house_capacity = null;
        row_count = null;
    }
    public RHouse(String house_id) {
        this();
        this.house_id = house_id;
    }
//-----------------------------------------------------------------------------
    public void setHouseID(String in) {
        set(HouseColumn.HOUSE_ID, in);
    }
    public void setHouseName(String in) {
        set(HouseColumn.HOUSE_NAME, in);
    }
    public void setHouseCapacity(int in) {
        set(HouseColumn.HOUSE_CAPACITY, Integer.toString(in));
    }
    public void setRow(int in) {
        set(HouseColumn.ROW_NUMBER, Integer.toString(in));
    }
    private void set(String id, String in) {
        if (id == HouseColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == HouseColumn.HOUSE_NAME) {
            house_name = in;
        }
        else if (id == HouseColumn.HOUSE_CAPACITY) {
            house_capacity = in;
        }
        else if (id == HouseColumn.ROW_NUMBER) {
            row_count = in;
        }
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public String getHouseID() {
        return house_id;
    }
    public String getHouseName() {
        return house_name;
    }
    public int getHouseCapacity() {
        return Integer.parseInt(house_capacity);
    }
    public int getRow() {
        return Integer.parseInt(row_count);
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect(HouseSQL.s1);
            db.setXxx(1, house_id);
            db.executeQuery();
            if (db.queryHasNext()) {
                setHouseName(db.getXxx(HouseColumn.HOUSE_NAME));
                setHouseCapacity(db.getXxx(HouseColumn.HOUSE_CAPACITY, 0));
                setRow(db.getXxx(HouseColumn.ROW_NUMBER, 0));
            }
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
        this.commitChange();
        if (this.isNew()) {
            return commitInsert();
        }
        return false;
    }
    
    // assumed not to update
    public boolean commitUpdate() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(HouseSQL.i4);
            db.setResult();
            db.setXxx(2, house_name);
            db.setXxx(3, house_capacity);
            db.setXxx(4, row_count);
            db.setXxx(5, house_id);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean commitInsert() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(HouseSQL.i4);
            db.setResult();
            db.setXxx(2, house_name);
            db.setXxx(3, house_capacity);
            db.setXxx(4, row_count);
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
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
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
