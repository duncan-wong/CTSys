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
public class RHouseCol extends UpdatableBean {
    private ArrayList<RHouse> houses;
    private ArrayList<RHouse> housesWaitForDelete;
//------------------------------------------------------------------------------
    public RHouseCol() {
        houses = new ArrayList<RHouse>();
        housesWaitForDelete = new ArrayList<RHouse>();
    }
//------------------------------------------------------------------------------
    public int count() {
        return houses.size();
    }
    public RHouse[] getAllHouse() {
        return houses.toArray(new RHouse[houses.size()]);
    }
    public RHouse getAt(int id) {
        return houses.get(id);
    }
//------------------------------------------------------------------------------
    public void addHouse(RHouse r) {
        houses.add(r);
    }
    public void removeHouse(RHouse r) {
        houses.remove(r);
        housesWaitForDelete.add(r);
    }
//------------------------------------------------------------------------------
    
    @Override
    public boolean fetchDBData() {
        houses.clear();
        try {
            DBconnect db = new DBconnect(HouseSQL.s1);
            db.setXxx(1, null);
            db.executeQuery();
            while (db.queryHasNext()) {
                RHouse temp = new RHouse();
                temp.setHouseID(db.getXxx(HouseColumn.HOUSE_ID));
                temp.setHouseName(db.getXxx(HouseColumn.HOUSE_NAME));
                temp.setHouseCapacity(db.getXxx(HouseColumn.HOUSE_CAPACITYU, 0));
                temp.setTotalRow(db.getXxx(HouseColumn.TOTAL_ROW, 0));
                temp.afterInitialization();
                houses.add(temp);
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
        super.commitChange();
        for (int i=0; i<houses.size(); i++) {
            if (!houses.get(i).commitChange()) {
                return false;
            }
        }
        for (int i=0; i<housesWaitForDelete.size(); i++) {
            if (!housesWaitForDelete.get(i).commitDelete()) {
                return false;
            }
        }
        housesWaitForDelete.clear();
        return true;
    }
}
