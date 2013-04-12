/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author A
 */
public class CallableStmtCtrl {
    private CallableStatement cstmt;
//---------------------------------------------------------------------------
    public CallableStmtCtrl() {
        cstmt = null;
    }
    public void setXxx(int id, int in)
            throws SQLException {
        cstmt.setInt(id, in);
    }
    public void setXxx(int id, String in)
            throws SQLException {
        cstmt.setString(id, in);
    }
    public void disconnect()
            throws SQLException {
        if (cstmt != null)
            cstmt.close();
    }
    public void setTo(CallableStatement cstmt)
            throws SQLException {
        this.cstmt = cstmt;
    }
    public void executeQuery(ResultSetCtrl rs)
            throws SQLException {
        cstmt.executeQuery();
        rs.setTo(cstmt.getResultSet());
    }
}
