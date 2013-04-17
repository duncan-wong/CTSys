/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DUNCAN
 */
public class Account_create extends HttpServlet {

   
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //call from a url-pattern
        //provide the registration form
        
        beans.RUser rUser = new beans.RUser();
        request.setAttribute(common.BeansConfig.rUser, rUser);
        
        //dispatch
        this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_signUp).forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //form submission
        
        beans.RUser rUser = new beans.RUser();
        request.setAttribute(common.BeansConfig.rUser, rUser);
        
        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        String passwordr = request.getParameter("passwordr");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
      
        
        //validation
        if (common.Validation.isPhone(phone)){
            rUser.setUserPhone(phone);
        }
        else{
            isSafeToCommit = false;
            errorMsg.put("phone", "Invalid phone number");
        }
        
        if (common.Validation.isEmail(email)){
            rUser.setUserEmail(email);
        }
        else{
            isSafeToCommit = false;
            errorMsg.put("email", "Invalid email address");
        }
         
       
        //commit change
        if (isSafeToCommit){
            try{
                //rUser.commitChange();
                isCommitted = true;
            }
            catch(Exception e){
                errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
            }
        }
        
        if (isCommitted){
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_login));
        }
        else{
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute(common.BeansConfig.rUser, rUser);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_signUp).forward(request, response);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
