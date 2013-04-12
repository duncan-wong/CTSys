
import common.jdbc.DBconnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ATesting extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String action = request.getParameter("action");
        this.doSearchEntry(request, response);
        if (action != null) {
            // call different action depends on the action parameter
            if (action.equalsIgnoreCase("search")) {
                this.doSearchEntry(request, response);
            }
        }

        this.doPrepareSearch(request, response);
    }

    private void doPrepareSearch(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Phonebook Directory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Phonebook Directory (Search)</h1>");
            out.println("<div style='width:600px'>");
            out.println("<fieldset>");
            out.println("<legend>Search</legend>");
            out.println("<form method='POST' action='" + request.getRequestURI() + "'>");
            out.println("<input name='action' type='hidden' value='search' />");
            out.println("<p>Name:");
            out.println("<input name='name' type='text' size='25' maxlength='255' value='' />");
            out.println("<input type='submit' value='Search!' /></p>");
            out.println("</form>");
            out.println("</fieldset>");
        }
        finally {
            out.close();
        }
    }

    private void doSearchEntry(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String searchName = request.getParameter("name");
//-------------------------------------------------------------------------
            /**
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup("jdbc/phonebook");
            Connection con = ds.getConnection();
            
            String procedure = "{ call show_moviedetail(?) }";
            CallableStatement cstmt = con.prepareCall(procedure);
            
            cstmt.setString(1, "cnt");
            cstmt.executeQuery();
            ResultSet rs;
            rs = cstmt.getResultSet();
            **/
//----------------------------------------------------------------------
            DBconnect db = new DBconnect();
            String procedure = "{ call show_moviedetail(?) }";
            db.prepareCall(procedure);
            db.setXxx(1, "EN");
            db.executeQuery();
//-----------------------------------------------------------------------
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Phonebook Directory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Phonebook Directory (Search Result)</h1>");
            out.println("<div style='width:600px'>");
            out.println("<fieldset>");
            out.println("<legend>Searching for ...</legend>");
            out.println("<p>Name: " + searchName + "<br/><br/></p>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<legend>Results</legend>");
            out.println("<div><table style='width:100%'>");
            out.println("<thead>");
            out.println("<th align='left'>Name</th><th align='left'>Phone Number</th>");
            out.println("</thead>");
            out.println("<tbody>");
            while (db.executeHasNext()) {
                out.println("<tr>");
                out.println("<td>" + db.getXxx(1,"") + "</td>");
                out.println("<td>" + db.getXxx(2,"") + "</td>");
                out.println("<td>" + db.getXxx(3,"") + "</td>");
                out.println("<td>" + db.getXxx(4,"") + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table></div>");
            out.println("<br/><a href='" + request.getRequestURI() + "'>Back</a>");
            out.println("</fieldset>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            db.disconnect();
        }
        catch (NamingException e) {
            out.println("<div style='color: red'>" + e.toString() + "</div>");
        } catch (SQLException e) {
            out.println("<div style='color: red'>" + e.toString() + "</div>");
        } finally {
            out.close();
        }
    }

    private String htmlEncode(String s) {

        StringBuffer sb = new StringBuffer(s.length() * 2);

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if ((ch >= '?' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch == ' ') || (ch == '\n')) {
                sb.append(ch);
            }
            else {
                switch(ch) {
                    case '>':
                        sb.append("&gt;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#039;");
                        break;
                    case '"':
                        sb.append("&quot;");
                        break;
                    default:
                        sb.append("&#");
                        sb.append(new Integer(ch).toString());
                        sb.append(';');
                }
            }
        }

        return sb.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
