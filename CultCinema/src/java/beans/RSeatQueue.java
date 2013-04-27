/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.Bean;
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
public class RSeatQueue extends Bean {
    private String search_showingID;
    private String search_seatNum;
    private String search_rowNum;
    private ArrayList<RSeat> seatQueue;
//------------------------------------------------------------------------------
    public RSeatQueue() {
        search_showingID = null;
        search_seatNum = null;
        search_rowNum = null;
        seatQueue = new ArrayList<RSeat>();
    }
//------------------------------------------------------------------------------
    public void searchMovieShowID(String in) {
        search_showingID = in;
    }
    
    
    public void searchSeatNumber(int in) {
        search_seatNum = Integer.toString(in);
    }
    public void searchSeatNumber(String in) {
        search_seatNum = in;
    }
    
    
    public void searchRowNumber(int in) {
        search_rowNum = Integer.toString(in);
    }
    public void searchRowNumber(String in) {
        search_rowNum = in;
    }
//------------------------------------------------------------------------------
    public int getCount() {
        return seatQueue.size();
    }
    public RSeat[] getQueue() {
        return seatQueue.toArray(new RSeat[seatQueue.size()]);
    }
//------------------------------------------------------------------------------
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect("{ call show_SeatQueue(?,?,?) }");
            db.setXxx(1, search_showingID);
            db.setXxx(2, search_rowNum);
            db.setXxx(3, search_seatNum);
            db.executeQuery();
            while (db.queryHasNext()) {
                RSeat temp = new RSeat();
                temp.setPaymentStatus(db.getXxx("payment_status"));
                temp.setBookingID(db.getXxx("booking_id"));
                temp.setRowNum(db.getXxx("row_number", 0));
                temp.setSeatNum(db.getXxx("seat_number", 0));
                temp.setMovieShowID(db.getXxx("showing_id"));
                seatQueue.add(temp);
            }
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(RSeatQueue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RSeatQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
