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
    public void updated() {
        if (delete || insert)
            return;
        update = true;
    }
    public void inserted() {
        insert = true;
        update = false;
    }
    public void deleted() {
        delete = true;
        update = false;
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
