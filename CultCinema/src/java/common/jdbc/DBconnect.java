/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc;

import java.sql.Connection;
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
    public boolean executeHasNext()
            throws SQLException {
        return rs.hasNext();
    }
    public void executeQuery()
            throws SQLException{
        cstmt.executeQuery(rs);
    }
    public int executeUpdate(String sql){
        return 0;
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
    public int getXxx(int id, int out)
            throws SQLException {
        return rs.getInt(id);
    }
    public String getXxx(int id, String out)
            throws SQLException {
        return rs.getString(id);
    }
}
