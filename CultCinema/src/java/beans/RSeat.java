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
    private String seat_status;
    private String row_number;
    private String seat_number;
    private String booking_id;
    private String showing_id;
    private String payment_status;
//-----------------------------------------------------------------------------
    public RSeat() {
        super();
        house_id = null;
        row_number = null;
        seat_number = null;
        seat_status = null;
        showing_id = null;
        booking_id = null;
        payment_status = null;
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
    public void setActiveStatus(String in) {
        set(SeatColumn.ACTIVE, in);
    }
    public void setBookingID(String in) {
        set(SeatColumn.BOOKING_ID, in);
    }
    public void setMovieShowID(String in) {
        set(SeatColumn.SHOWING_ID, in);
    }
    public void setPaymentStatus(String in) {
        payment_status = in;
    }
    
    public void setSeatId(String seatId){
        set(SeatColumn.SEAT_NUMBER, seatId.substring(1, seatId.length()));
        set(SeatColumn.ROW_NUMBER, String.valueOf(seatId.charAt(0) - 'A'));
    }
    
    private void set(String id, String in) {
        if (id.equals(SeatColumn.ROW_NUMBER)) {
            row_number = in;
        }
        else if (id.equals(SeatColumn.SEAT_NUMBER)) {
            seat_number = in;
        }
        else if (id.equals(SeatColumn.ACTIVE)) {
            seat_status = in;
        }
        else if (id.equals(SeatColumn.HOUSE_ID)) {
            house_id = in;
        }
        else if (id.equals(SeatColumn.BOOKING_ID)) {
            booking_id = in;
        }
        else if (id.equals(SeatColumn.SHOWING_ID)) {
            showing_id = in;
        }
        this.setChangedTrue();
    }
//-----------------------------------------------------------------------------
    public boolean isActive_Seat() {
        if ("0".equals(seat_status)) {
            return false;
        }
        return true;
    }
    
    public boolean isBooked() {
        if (booking_id ==  null) {
            return false;
        }
        return true;
    }
    
    //check the booking is Refund pending or not
    public boolean isPendingRefund() {
        if ("2".equals(seat_status)) {
            return true;
        }
        return false;
    }
    
    // 0 == disable, 2 == refund pending
    public String getActiveStatus(){
        return this.seat_status;
    }
    
    public String getPaymentStatus() {
        return payment_status;
    }
    
    // 0 = booked, 1 = available, -1 = disabled
    public int getSeatStatus(){
        if (this.isActive_Seat()){
            if (this.isBooked()){
                return 0;
            }
            else{
                return 1;
            }
        }
        return -1;
    }
    public String getMovieShowID() {
        return showing_id;
    }
    public String getBookingID() {
        return booking_id;
    }
    // row number
    public int getRowNum() {
        return Integer.parseInt(row_number);
    }
    
    // seat number
    public int getSeatNum() {
        return Integer.parseInt(seat_number);
    }
    
    // row in charactor
    public String getRowID() {
        char c = (char) ('A' + Integer.parseInt(row_number) - 1);
        return "" + c;
    }
    
    // seat left padding with two '0'
    //  +
    // row in charactor
    public String getSeatID() {
        return getRowID() + String.format("%02d", Integer.parseInt(seat_number));
    }
    
    public String getSeatIdInRow(){
        return String.format("%02d", Integer.parseInt(seat_number));
    }
    
    // left padding movieShowID with six '0'
    //  +
    // seatID
    public String getTicketID() {
        return String.format("%06d", Integer.parseInt(showing_id)) + "-" + getSeatID();
    }
//-----------------------------------------------------------------------------
    /**
     * Input:
     *          showing_id
     *          row_number
     *          seat_number
     * 
     * Output:
     *          booking_id
     */
    @Override
    public boolean fetchDBData() {
        try {
            DBconnect db = new DBconnect("{ show_ShowingSeat(?,?,?,?) }");
            db.setXxx(1, showing_id);
            db.setXxx(2, null);
            db.setXxx(3, row_number);
            db.setXxx(4, seat_number);
            db.executeQuery();
            if (db.queryHasNext()) {
                booking_id = db.getXxx("booking_id");
            }
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(RSeat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RSeat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean commitChange() {
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
        
        super.commitChange();
        return true;
    }
    
    // for movie show ticket use
    private boolean commitInsert_Ticket() {
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
    private boolean commitUpdate_Seat() {
        int checking = 0;
        try {
            DBconnect db = new DBconnect(SeatSQL.u4_House);
            db.setResult();
            db.setXxx(2, house_id);
            db.setXxx(3, row_number);
            db.setXxx(4, seat_number);
            db.setXxx(5, seat_status);
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
