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
        setHouseID(house_id);
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
        return get(HouseColumn.HOUSE_ID);
    }
    public String getHouseName() {
        return get(HouseColumn.HOUSE_NAME);
    }
    public int getHouseCapacity() {
        return Integer.parseInt(get(HouseColumn.HOUSE_CAPACITY));
    }
    public int getRow() {
        return Integer.parseInt(get(HouseColumn.ROW_NUMBER));
    }
    private String get(String id) {
        if (id == HouseColumn.HOUSE_ID) {
            return house_id;
        }
        else if (id == HouseColumn.HOUSE_NAME) {
            return house_name;
        }
        else if (id == HouseColumn.HOUSE_CAPACITY) {
            return house_capacity;
        }
        else if (id == HouseColumn.ROW_NUMBER) {
            return row_count;
        }
        return "";
    }
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
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
        if (this.isChanged()) {
            return commitUpdate();
        }
        else if (this.isNew()) {
            return commitInsert();
        }
        return false;
    }
    
    public boolean commitUpdate() {
        return false;
    }
    
    public boolean commitInsert() {
        return false;
    }
    
    public boolean commitDelete() {
        return false;
    }
}
