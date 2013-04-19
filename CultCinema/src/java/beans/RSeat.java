/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;
import beans.sqlColumnName.SeatColumn;

/**
 *
 * @author A
 */
public class RSeat extends UpdatableBean {
    private String booking_id;
    private String row_number;
    private String seat_number;
    private String seat_id;
//-----------------------------------------------------------------------------
    public RSeat() {
        super();
        row_number = null;
        seat_number = null;
        seat_id = null;
        setEmpty();
    }
//-----------------------------------------------------------------------------
    public void setRowNum(int in) {
        set(SeatColumn.ROW_NUMBER, Integer.toString(in));
        updateSeatID();
    }
    public void setSeatNum(int in) {
        set(SeatColumn.SEAT_NUMBER, Integer.toString(in));
        updateSeatID();
    }
    public void setBookingID(String in) {
        set(SeatColumn.BOOKING_ID, in);
    }
    public void setEmpty() {
        set(SeatColumn.ISEMPTY, "");
    }
    private void set(String id, String in) {
        if (id == SeatColumn.ROW_NUMBER) {
            row_number = in;
        }
        else if (id == SeatColumn.SEAT_NUMBER) {
            seat_number = in;
        }
        else if (id == SeatColumn.BOOKING_ID) {
            booking_id = in;
        }
        else if (id == SeatColumn.ISEMPTY) {
            booking_id = null;
        }
        this.setChangedTrue();
    }
    private void updateSeatID() {
        char row_id;
        row_id = (char) ('A' - 1 + Integer.parseInt(row_number));
        seat_id = row_id + seat_number;
    }
//-----------------------------------------------------------------------------
    public int getRowNum() {
        return Integer.parseInt(row_number);
    }
    public int getSeatNum() {
        return Integer.parseInt(seat_number);
    }
    public String getSeatID() {
        return seat_id;
    }
    public boolean isBooked() {
        if (booking_id == null) {
            return false;
        }
        else {
            return true;
        }
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean commitChange() {
        super.commitChange();
        if (this.isChanged()) {
            if (isBooked()) {
                return commitInsert();
            }
            else {
                return commitDelete();
            }
        }
        return false;
    }
    public boolean commitInsert() {
        int checking = 0;
        if (checking == 0) {
            return true;
        }
        return false;
    }
    public boolean commitDelete() {
        int checking = 0;
        if (checking == 0) {
            return true;
        }
        return false;
    }
}
