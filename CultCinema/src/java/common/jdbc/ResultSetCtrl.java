/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc;

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
    public int getInt(int id)
            throws SQLException {
        return rs.getInt(id);
    }
    public String getString(int id)
            throws SQLException {
        return rs.getString(id);
    }
    public boolean hasNext()
            throws SQLException {
        return rs.next();
    }
    public void setTo(ResultSet rs) {
        this.rs = rs;
    }
}
