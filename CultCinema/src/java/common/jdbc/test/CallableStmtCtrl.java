/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc.test;

import java.sql.CallableStatement;
import java.sql.Date;
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
    public void disconnect()
            throws SQLException {
        if (cstmt != null)
            cstmt.close();
    }
//---------------------------------------------------------------------------
    public void setXxx(int id, int in)
            throws SQLException {
        cstmt.setInt(id, in);
    }
    public void setXxx(int id, String in)
            throws SQLException {
        cstmt.setString(id, in);
    }
//---------------------------------------------------------------------------
    public void setTo(CallableStatement cstmt)
            throws SQLException {
        this.cstmt = cstmt;
    }
    public boolean executeQuery(ResultSetCtrl rs)
            throws SQLException {
        if (cstmt.execute()) {
            rs.setTo(cstmt.getResultSet());
            return true;
        }
        else
            return false;
    }
    public int executeUpdate()
            throws SQLException {
        // insert update drop
        return cstmt.executeUpdate();
    }
}
