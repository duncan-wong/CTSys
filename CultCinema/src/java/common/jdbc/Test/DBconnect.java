/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author A
 */
public class DBconnect {
    private Connection con;
    private CallableStmtCtrl cstmt;
    private ResultSetCtrl rs;
//----------------------------------------------------------------------------
    public DBconnect()
            throws NamingException, SQLException {
        connect();
    }
    private void connect()
            throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context)initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/cinema");
        con = ds.getConnection();
        cstmt = new CallableStmtCtrl();
        rs = new ResultSetCtrl();
    }
    public void disconnect()
            throws SQLException {
        if (con != null)
            con.close();
        cstmt.disconnect();
        rs.disconnect();
    }
    public void prepareCall(String cmd)
            throws SQLException {
        cstmt.setTo(con.prepareCall(cmd));
    }
    public boolean resultSetHasNext()
            throws SQLException {
        return rs.hasNext();
    }
    public boolean executeQuery()
            throws SQLException {
        if (cstmt.executeQuery(rs))
            return true;
        else
            return false; // no result
    }
    public boolean executeUpdate()
            throws SQLException {
        if (cstmt.executeUpdate() > 0)
            return true;
        else
            return false; // update failed
    }
//---------------------------------------------------------------------------
    public void setXxx(int id, int in)
            throws SQLException {
        cstmt.setXxx(id, in);
    }
    public void setXxx(int id, String in)
            throws SQLException {
        cstmt.setXxx(id, in);
    }
//---------------------------------------------------------------------------
    public int getXxx(String id, int out)
            throws SQLException {
        return rs.getInt(id);
    }
    public String getXxx(String id, String out)
            throws SQLException {
        return rs.getString(id);
    }
}
