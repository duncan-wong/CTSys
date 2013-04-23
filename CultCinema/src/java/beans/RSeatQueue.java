/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import common.jdbc.DBconnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author A
 */
public class RSeatQueue extends RSeat {
    public RSeatQueue() {
        super();
    }
    
    @Override
    public boolean commitChange() {
        return false;
    }
    
    public boolean commitInsert() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect("{ ? = call insert_SeatQueue(?,?,?,?) }");
            db.setResult();
            db.setXxx(2, getMovieShowID());
            db.setXxx(3, getRowNum());
            db.setXxx(4, getSeatNum());
            db.setXxx(5, getBookingID());
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RSeatQueue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RSeatQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean commitDelete() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect("{ ? = call delete_SeatQueue(?) }");
            db.setResult();
            db.setXxx(2, getBookingID());
            db.executeUpdate();
            checking = db.getResult();
            db.disconnect();
            if (checking == 0) {
                return true;
            }
        } catch (NamingException ex) {
            Logger.getLogger(RSeatQueue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RSeatQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
