/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
    private CallableStatement cstmt;
    private ResultSet rs;
//----------------------------------------------------------------------------
    public DBconnect()
            throws NamingException, SQLException {
        connect();
    }
    public DBconnect(String cmd)
            throws NamingException, SQLException {
        this();
        prepareCall(cmd);
    }
    private void connect()
            throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context)initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/cinema");
        con = ds.getConnection();
        cstmt = null;
        rs = null;
    }
    public void disconnect()
            throws SQLException {
        if (con != null)
            con.close();
        if (cstmt != null)
            cstmt.close();
        if (rs != null)
            rs.close();
    }
//---------------------------------------------------------------------------
    public void prepareCall(String cmd)
            throws SQLException {
        cstmt = con.prepareCall(cmd);
    }
    public boolean executeQuery()
            throws SQLException {
        if (cstmt.execute()) {
            rs = cstmt.getResultSet();
            return true;
        }
        else
            return false; // no result
    }
    public int executeUpdate()
            throws SQLException {
        int rowsAffected = cstmt.executeUpdate();
        return rowsAffected;
    }
//---------------------------------------------------------------------------
    public boolean queryHasNext()
            throws SQLException {
        return rs.next();
    }
//---------------------------------------------------------------------------
    public void setXxx(int id, int in)
            throws SQLException {
        cstmt.setInt(id, in);
    }
    public void setXxx(int id, String in)
            throws SQLException {
        if (in == null) {
            cstmt.setNull(id, Types.NULL);
        }
        else {
            cstmt.setString(id, in);
        }
    }
    public void setResult()
            throws SQLException {
        cstmt.registerOutParameter(1, Types.INTEGER);
    }
//---------------------------------------------------------------------------
    public int getXxx(String id, int out)
            throws SQLException {
        return rs.getInt(id);
    }
    public String getXxx(String id)
            throws SQLException {
        return rs.getString(id);
    }
    public int getResult()
            throws SQLException {
        return cstmt.getInt(1);
    }
}
