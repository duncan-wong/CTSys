/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RMovieShow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class M_MovieShow_create extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // call from a url-pattern
        // provide the registration form
        RMovieShow rMovieShow = new RMovieShow();
        request.setAttribute("rMovieShow", rMovieShow);

        // dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_m_MovieShow_create).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RMovieShow rMovieShow = new RMovieShow();
        request.setAttribute("rMovieShow", rMovieShow);

        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();

        String houseID = request.getParameter("houseID");
        String startDate = request.getParameter("startDate");
        String startTime = request.getParameter("startTime");
        String ticket_price = request.getParameter("ticket_price");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
