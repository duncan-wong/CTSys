/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.manager;

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
public class M_Houses_edit extends HttpServlet {
    private String houseID;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        houseID = request.getParameter("houseID");
        beans.RHouse rHouse = new beans.RHouse();
        rHouse.setHouseID(houseID);
        rHouse.fetchDBData();
        request.setAttribute("rHouse", rHouse);
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_Houses_edit).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        beans.RHouse rHouse = new beans.RHouse();
        rHouse.setHouseID(houseID);
        rHouse.fetchDBData();
        
        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        String houseName = request.getParameter("houseName");
        
        
        
        if (!common.Validation.isNull(houseName)
            && common.Validation.isCharPlusDigit(houseName)) {
            rHouse.setHouseName(houseName);
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("houseName", "Invalid house name");
        }
        
        
        if (isSafeToCommit) {
            try {
                rHouse.commitChange();
                isCommitted = true;
            }
            catch(Exception e){
                errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
            }
        }
        
        if (isCommitted) {
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURLm_Houses));
        }
        else {
            request.setAttribute("rHouse", rHouse);
            request.setAttribute("errorMsg", errorMsg);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_Houses_edit).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
