/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

import beans.RSeat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class M_HouseSeat_edit extends HttpServlet {
    private String houseID;
    
    private RSeat[] seatStringDigest(String str, int status) {
        ArrayList<RSeat> seats = new ArrayList<RSeat>();
        
        if (str != null && !str.equals("")) {
            String seatStr[] = str.split(",");
            if (seatStr.length > 0) {
                for (int i=0; i<seatStr.length; i++) {
                    RSeat rSeat = new beans.RSeat(houseID);
                    String num;
                    rSeat.setActiveStatus(status);
                    if (seatStr[i].contains("-")) {
                        num = seatStr[i].split("-")[0];
                        rSeat.setRowNum(Integer.parseInt(num));
                        num = seatStr[i].split("-")[1];
                        rSeat.setSeatNum(Integer.parseInt(num));
                    }
                    else return null;
                    
                    seats.add(rSeat);
                }
            }
            else return null;
        }
        else return null;
        return seats.toArray(new RSeat[seats.size()]);
    }
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        houseID = request.getParameter("houseID");
        beans.RHouse rHouse = new beans.RHouse();
        rHouse.setHouseID(houseID);
        rHouse.fetchDBData();
        request.setAttribute("rHouse", rHouse);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_HouseSeat_edit).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        beans.RHouse rHouse = new beans.RHouse();
        rHouse.setHouseID(houseID);
        rHouse.fetchDBData();
        
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        // get data
        String selectedSeats = request.getParameter("selectedSeats");
        String selectedSeats_d = request.getParameter("selectedSeats_d");
        
        // digest string
        RSeat deactivateSeat[], activateSeat[];
        deactivateSeat = seatStringDigest(selectedSeats, 0);
        activateSeat = seatStringDigest(selectedSeats_d, 1);
        
        // commit
        try {
            if (!common.Validation.isNull(selectedSeats)) {
                for (int i=0; i<deactivateSeat.length; i++) {
                    deactivateSeat[i].commitChange();
                }
            }
            if (!common.Validation.isNull(selectedSeats_d)) {
                for (int i=0; i<activateSeat.length; i++) {
                    activateSeat[i].commitChange();
                }
            }
            isCommitted = true;
        } catch (Exception e) {
            errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
        }
        
        // redirect OR dispatch
        if (isCommitted) {
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLm_HouseSeat_edit+"?houseID="+houseID));
        }
        else {
            request.setAttribute("rHouse", rHouse);
            request.setAttribute("errorMsg", errorMsg);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_HouseSeat_edit).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
