/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A
 */
public class M_HouseStat extends HttpServlet {
    private String houseID;
    private String numOfActiveSeat;
    
    private void updateActiveSeatCount(beans.RHouse r) {
        beans.RSeat seats[][] = r.getAllSeats();
        int count = 0;
        for (int i=0; i<seats.length; i++) {
            for (int j=0; j<seats[i].length; j++) {
                if (seats[i][j].isActive_Seat()) {
                    count++;
                }
            }
        }
        numOfActiveSeat = Integer.toString(count);
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        houseID = request.getParameter("houseID");
        
        beans.RHouse rHouse = new beans.RHouse();
        rHouse.setHouseID(houseID);
        rHouse.fetchDBData();
        updateActiveSeatCount(rHouse);
        
        beans.RMovieShowCol rShowCol = new beans.RMovieShowCol();
        rShowCol.searchHouseID(houseID);
        rShowCol.searchTimeAfter("2000.01.01");
        rShowCol.fetchDBData();
        
        // put the bean into request
        request.setAttribute("rHouse", rHouse);
        request.setAttribute("rShowCol", rShowCol);
        int disabledCount = rHouse.getHouseCapacity() - Integer.parseInt(numOfActiveSeat);
        request.setAttribute("disabledCount", disabledCount);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_HouseStat).forward(request, response);
    }
    
    
    
    
    
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
