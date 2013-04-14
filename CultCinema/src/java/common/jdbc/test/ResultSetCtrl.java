/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc.test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author A
 */
public class ResultSetCtrl {
    ResultSet rs;
//----------------------------------------------------------------------------
    public ResultSetCtrl() {
        rs = null;
    }
    public void disconnect()
            throws SQLException {
        if (rs != null)
            rs.close();
    }
    public boolean hasNext()
            throws SQLException {
        return rs.next();
    }
//----------------------------------------------------------------------------
    public int getInt(String id)
            throws SQLException {
        return rs.getInt(id);
    }
    public String getString(String id)
            throws SQLException {
        return rs.getString(id);
    }
//----------------------------------------------------------------------------
    public void setTo(ResultSet rs) {
        this.rs = rs;
    }
}
