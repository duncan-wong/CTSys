/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sql;

/**
 *
 * @author A
 */
public class DBstatus {
    private boolean update;
    private boolean insert;
    private boolean delete;
//----------------------------------------------------------------------------
    public DBstatus() {
        reset();
    }
//----------------------------------------------------------------------------
    public void reset() {
        update = false;
        insert = false;
        delete = false;
    }
    public void setUpdate() {
        update = true;
    }
    public void setInsert() {
        insert = true;
    }
    public void setDelete() {
        delete = true;
    }
//----------------------------------------------------------------------------
    public boolean waitUpdate() {
        return update;
    }
    public boolean waitInsert() {
        return insert;
    }
    public boolean waitDelete() {
        return delete;
    }
}
