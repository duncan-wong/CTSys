/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sql.HouseSQL;
import beans.sql.SeatSQL;
import beans.sqlColumnName.HouseColumn;
import beans.sqlColumnName.SeatColumn;
import common.jdbc.DBconnect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 * CASE 1:  input house_id
 * Mean:    get house detail and its seats [ active / inactive ]
 * Has:
 *          - total_row
 *          - house_capacity
 *          - house_name
 *          - seats of house
 * 
 * 
 * CASE 2:  input movieShow_id
 * Mean:    get the ticket status in the movieShow [ booked / empty ]
 * Has :
 *          - house_id
 *          - total_row
 *          - seats of the movieShow
 * 
 */
public class RHouse extends UpdatableBean {
    private String showing_id;
    private String house_id;
    private String house_name;
    private String house_capacity;
    private String total_row;
    private RSeat[][] seats;
    private ArrayList<RSeatQueue> seatsQueue;
//------------------------------------------------------------------------------
    public RHouse() {
        super();
        showing_id = null;
        house_id = null;
        house_name = null;
        house_capacity = null;
        total_row = null;
        seats = null;
        seatsQueue = new ArrayList<RSeatQueue>();
    }
    public RHouse(String house_id) {
        this.house_id = house_id;
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
    public void setMovieShowID(String in) {
        set(HouseColumn.SHOWING_ID, in);
    }
    private void set(String id, String in) {
        this.setChangedTrue();
        if (id.equals(HouseColumn.HOUSE_ID)) {
            house_id = in;
        }
        else if (id.equals(HouseColumn.HOUSE_NAME)) {
            house_name = in;
        }
        else if (id.equals(HouseColumn.HOUSE_CAPACITYU)) {
            house_capacity = in;
        }
        else if (id.equals(HouseColumn.TOTAL_ROW)) {
            total_row = in;
        }
        else if (id.equals(HouseColumn.SHOWING_ID)) {
            showing_id = in;
        }
    }
    
    // add a seat queue
    public void addSeatQueue(RSeatQueue r) {
        seatsQueue.add(r);
    }
    
    // delete a seat queue directly **hard delete**
    public void deleteSeatQueue(RSeatQueue r) {
        seatsQueue.remove(r);
        r.commitChange();
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
    public RSeat getSeatAt(String seatId){
        int row = seatId.charAt(0) - 'A';
        int seat = Integer.valueOf(seatId.substring(1, 2));
        return this.getSeatAt(row, seat);
    }
    
    // get the seats
    public RSeat[][] getAllSeat() {
        return seats;
    }
    
    // get the queueing seats
    public RSeatQueue[] getAllSeatQueue() {
        return seatsQueue.toArray(new RSeatQueue[seatsQueue.size()]);
    }
    public String getMovieShowID() {
        return showing_id;
    }
    public String getSales() {
        String sales = "";
        try {
            DBconnect db = new DBconnect(HouseSQL.s1_Sales);
            db.setXxx(1, house_id);
            db.executeQuery();
            sales = db.getXxx(HouseColumn.SALES);
            db.disconnect();
        } catch (NamingException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        super.fetchDBData();
        if (showing_id != null) {
            return fetchMovieShowSeating();
        }
        else {
            return fetchHouseData();
        }
    }
    
    
    // when movieShowID != null, get the show seating plan
    private boolean fetchMovieShowSeating() {
        try {
            ArrayList<RSeat[]> rows = new ArrayList<RSeat[]>();
            ArrayList<RSeat> oneRow = new ArrayList<RSeat>();
            DBconnect db = new DBconnect(SeatSQL.s1_Showing);
            db.setXxx(1, showing_id);
            db.executeQuery();
            int rowCount = 1;
            while (db.queryHasNext()) {
                RSeat rsTemp = new RSeat();
                
                
                //store the row and clear the row temp
                if (rowCount + 1 == db.getXxx(SeatColumn.ROW_NUMBER, 0)) {
                    rows.add(oneRow.toArray(new RSeat[oneRow.size()]));
                    rowCount++;
                    oneRow.clear();
                    house_id = db.getXxx(SeatColumn.HOUSE_ID);
                }
                rsTemp.setMovieShowID(showing_id);
                rsTemp.setBookingID(db.getXxx(SeatColumn.BOOKING_ID));
                rsTemp.setRowNum(db.getXxx(SeatColumn.ROW_NUMBER, 0));
                rsTemp.setSeatNum(db.getXxx(SeatColumn.SEAT_NUMBER, 0));
                rsTemp.setActiveStatus(db.getXxx(SeatColumn.ACTIVE));
                rsTemp.afterInitialization();
                oneRow.add(rsTemp);
            }
            rows.add(oneRow.toArray(new RSeat[oneRow.size()]));
            seats = rows.toArray(new RSeat[rows.size()][]);
            total_row = Integer.toString(rows.size());
            db.disconnect();
            
            
            // get the seat queue according movieShowID
            seatsQueue.clear();
            db = new DBconnect("{ call show_SeatQueue(?) }");
            db.setXxx(1, showing_id);
            db.executeQuery();
            oneRow.clear();
            while (db.queryHasNext()) {
                RSeatQueue rsTemp = new RSeatQueue();
                rsTemp.setMovieShowID(showing_id);
                rsTemp.setBookingID(db.getXxx(SeatColumn.BOOKING_ID));
                rsTemp.setRowNum(db.getXxx(SeatColumn.ROW_NUMBER, 0));
                rsTemp.setSeatNum(db.getXxx(SeatColumn.SEAT_NUMBER, 0));
                rsTemp.setActiveStatus(db.getXxx(SeatColumn.ACTIVE));
                rsTemp.afterInitialization();
                seatsQueue.add(rsTemp);
            }
            db.disconnect();
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    // when movieShowID == null, get the house seating plan
    private boolean fetchHouseData() {
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
            this.afterInitialization();
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
//------------------------------------------------------------------------------
    @Override
    public boolean commitChange() {
        super.commitChange();
        
        // commit the seats
        for (int i=0; i<seats.length; i++) {
            for (int j=0; j<seats[i].length; j++) {
                if (!seats[i][j].commitChange()) {
                    return false;
                }
            }
        }
        
        // commit the queue ( insert only )
        for (int i=0; i<seatsQueue.size(); i++) {
            if (!seatsQueue.get(i).commitChange()) {
                return false;
            }
        }
        if (this.isNew()) {
            return commitInsert();
        }
        else if (this.isChanged()) {
            return commitUpdate();
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
    
    /**
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
