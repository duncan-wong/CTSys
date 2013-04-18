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
    private String showing_id;
    private String row_number;
    private String seat_number;
    private String seat_id;
    private boolean isBooked;
//-----------------------------------------------------------------------------
    public RSeat() {
        super();
        showing_id = null;
        row_number = null;
        seat_number = null;
        seat_id = null;
        isBooked = false;
    }
//-----------------------------------------------------------------------------
    public void setShowingID(String in) {
        set(SeatColumn.SHOWING_ID, in);
    }
    public void setRowNum(int in) {
        set(SeatColumn.ROW_NUMBER, Integer.toString(in));
        updateSeatID();
    }
    public void setSeatNum(int in) {
        set(SeatColumn.SEAT_NUMBER, Integer.toString(in));
        updateSeatID();
    }
    public void setBooked() {
        set(SeatColumn.ISBOOKED, "");
    }
    public void setEmpty() {
        set(SeatColumn.ISEMPTY, "");
    }
    private void set(String id, String in) {
        if (id == SeatColumn.SHOWING_ID) {
            showing_id = in;
        }
        else if (id == SeatColumn.ROW_NUMBER) {
            row_number = in;
        }
        else if (id == SeatColumn.SEAT_NUMBER) {
            seat_number = in;
        }
        else if (id == SeatColumn.ISBOOKED) {
            isBooked = true;
        }
        else if (id == SeatColumn.ISEMPTY) {
            isBooked = false;
        }
        this.setChangedTrue();
    }
    private void updateSeatID() {
        char row_id;
        row_id = (char) ('A' - 1 + Integer.parseInt(row_number));
        seat_id = row_id + seat_number;
    }
//-----------------------------------------------------------------------------
    public String getShowingID() {
        return showing_id;
    }
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
        return isBooked;
    }
//-----------------------------------------------------------------------------
    @Override
    public boolean commitChange() {
        super.commitChange();
        if (this.isChanged()) {
            return commitUpdate();
        }
        return false;
    }
    public boolean commitUpdate() {
        int checking = 0;
        if (checking == 0) {
            return true;
        }
        return false;
    }
}
