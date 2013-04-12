/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.jdbc;

/**
 *
 * @author A
 */
public class X__exampleJDBC {
    /**
    Context initCtx = new InitialContext();
    Context envCtx = (Context)initCtx.lookup("java:comp/env");
    DataSource ds = (DataSource)envCtx.lookup("jdbc/a");
    Connection con = ds.getConnection();
    <xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>
    Statement stmt = 
        con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
    ResultSet rs = stmt.executeQuery("  SELECT *
                                        FROM [phonebook]
                                        ORDER BY [Name] ASC");
    <xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>
    if (rs != null)
        rs.close();
    if (stmt != null)
        stmt.close();
    if (con != null)
        con.close();
//-------------------------------------------------------------------------------
    Context initCtx = new InitialContext();
    Context envCtx = (Context)initCtx.lookup("java:comp/env");
    DataSource ds = (DataSource)envCtx.lookup("jdbc/phonebook");
    Connection con = ds.getConnection();
    <xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>
    String procedure = "{ call searchPhoneRecord(?) }";
    CallableStatement cstmt = con.prepareCall(procedure);
    <xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>
    cstmt.setString(1, searchName);
    cstmt.executeQuery();
    ResultSet rs;
    rs = cstmt.getResultSet();
    <xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>
    if (rs != null) {
        rs.close();
    }
    if (cstmt != null) {
        cstmt.close();
    }
    if (con != null) {
        con.close();
    }
    **/
}
