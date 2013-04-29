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
public class M_Houses_create extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        beans.RHouse rHouse = new beans.RHouse();
        request.setAttribute("rHouse", rHouse);
        request.setAttribute("capacity", "");
        request.setAttribute("totalRow", "");
        
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_Houses_create).forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        beans.RHouse rHouse = new beans.RHouse();
        
        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        String houseName = request.getParameter("houseName");
        String capacity = request.getParameter("capacity");
        String totalRow = request.getParameter("totalRow");
        
        
        if (!common.Validation.isNull(houseName)
            && common.Validation.isCharPlusDigit(houseName)) {
            rHouse.setHouseName(houseName);
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("houseName", "Invalid house name");
        }
        
        if (common.Validation.isPhone(totalRow)) {
            rHouse.setTotalRow(Integer.parseInt(totalRow));
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("totalRow", "Invalid row");
            totalRow = "";
        }
        
        if (common.Validation.isPhone(capacity)) {
            if (common.Validation.isPhone(totalRow)
                && Integer.parseInt(capacity) >= Integer.parseInt(totalRow)) {
                rHouse.setHouseCapacity(Integer.parseInt(capacity));
            }
            else {
                isSafeToCommit = false;
                errorMsg.put("capacity", "Capacity must be larger than Row");
                capacity = "";
            }
        }
        else {
            isSafeToCommit = false;
            errorMsg.put("capacity", "Invalid capacity");
            capacity = "";
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
            request.setAttribute("capacity", capacity);
            request.setAttribute("totalRow", totalRow);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURLm_Houses_create).forward(request, response);
        }
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
