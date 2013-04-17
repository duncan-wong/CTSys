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
    private int[] rowMax;
//-----------------------------------------------------------------------------
    public RHouse() {
        super();
        house_id = null;
        house_name = null;
        rowMax = new int[100];
    }
//-----------------------------------------------------------------------------
    public void setHouseID(String in) {
        set(HouseColumn.HOUSE_ID, in);
    }
    public void setHouseName(String in) {
        set(HouseColumn.HOUSE_NAME, in);
    }
    public void setRowMax(int row, int max) {
        int in = row*1000 + max;
        set(HouseColumn.ROW_MAX, Integer.toString(in));
    }
    private void set(String id, String in) {
        if (id == HouseColumn.HOUSE_ID) {
            house_id = in;
        }
        else if (id == HouseColumn.HOUSE_NAME) {
            house_name = in;
        }
        else if (id == HouseColumn.ROW_MAX) {
            int row = Integer.parseInt(in)/1000;
            int max = Integer.parseInt(in)%1000;
            int index = row - 1;
            rowMax[index] = max;
        }
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public static RHouse[] getAllHouses() {
        ArrayList<RHouse> rHouseCol = new ArrayList<RHouse>();
        RHouse rhTemp = new RHouse();
        try {
            DBconnect db = new DBconnect(HouseSQL.s1);
            db.setXxx(1, null);
            db.executeQuery();
            int row;
            if (db.queryHasNext()) {
                row = db.getXxx(HouseColumn.ROW_NUMBER, 0);
                rhTemp.setHouseID(db.getXxx(HouseColumn.HOUSE_ID));
                rhTemp.setHouseName(db.getXxx(HouseColumn.HOUSE_NAME));
                rhTemp.setRowMax(row, db.getXxx(HouseColumn.ROW_MAX, 0));
            }
            while (db.queryHasNext()) {
                row = db.getXxx(HouseColumn.ROW_NUMBER, 0);
                if (row == 1) {
                    rHouseCol.add(rhTemp);
                    rhTemp = new RHouse();
                    rhTemp.setHouseID(db.getXxx(HouseColumn.HOUSE_ID));
                    rhTemp.setHouseName(db.getXxx(HouseColumn.HOUSE_NAME));
                }
                rhTemp.setRowMax(row, db.getXxx(HouseColumn.ROW_MAX, 0));
            }
            rHouseCol.add(rhTemp);
            return rHouseCol.toArray(new RHouse[rHouseCol.size()]);
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getHouseID() {
        return house_id;
    }
    public String getHouseName() {
        return house_name;
    }
    public int getRowMax(int row) {
        int id = row - 1;
        return rowMax[id];
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        super.fetchDBData();
        try {
            DBconnect db = new DBconnect(HouseSQL.s1);
            db.setXxx(1, house_id);
            db.executeQuery();
            if (db.queryHasNext()) {
                setHouseID(db.getXxx(HouseColumn.HOUSE_ID));
                setHouseName(db.getXxx(HouseColumn.HOUSE_NAME));
            }
            do {
                int row = db.getXxx(HouseColumn.ROW_NUMBER, 0);
                int max = db.getXxx(HouseColumn.ROW_MAX, 0);
                setRowMax(row, max);
            } while (db.queryHasNext());
            db.disconnect();
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
