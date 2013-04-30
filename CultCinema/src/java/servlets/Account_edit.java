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
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUNCAN
 */
public class Account_edit extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //redirect to /account for request not by post
        response.sendRedirect((common.URLConfig.getFullPath(common.URLConfig.SURL_account)));
        
    }
    
    private void processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //if it is a form submission
        HttpSession session = request.getSession(false);
        beans.SStatus sStatus = (beans.SStatus) session.getAttribute(common.BeansConfig.sStatus);
        
        //put RUser bean into request
        beans.RUser rUser = new beans.RUser(sStatus.getLoginId());
        rUser.fetchDBData();
        
        boolean isSafeToCommit = true;
        boolean isCommitted = false;
        
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String newPassword = request.getParameter("newPassword");
        String newPasswordRe = request.getParameter("newPasswordRe");
        
        String password = request.getParameter("password");
        Hashtable<String, String> errorMsg = new Hashtable<String, String>();
        
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
        
        if (!common.Validation.isNull(name)){
            name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            rUser.setUserName(name);
        }
        else{
            isSafeToCommit = false;
            errorMsg.put("name", "Invalid name");
        }
        
        if (!newPassword.equals(newPasswordRe)){
            isSafeToCommit = false;
            errorMsg.put("newPasswordRe", "Does not match the new password");
        }
        
        
        if (!rUser.checkPassword(password)){
            isSafeToCommit = false;
            errorMsg.put("password", "Incorrect password");
        }
        else if (isSafeToCommit 
                    && !common.Validation.isNull(newPassword)
                    && newPassword.equals(newPasswordRe)){
            rUser.setLoginPW(newPassword);
        }
        
        
        
        //commit change
        if (isSafeToCommit){
            try{
                rUser.commitChange();
                isCommitted = true;
            }
            catch(Exception e){
                errorMsg.put("pageError", "Sorry, the server has encounted an internal error. Please try again later.");
            }
        }
        
        if (isCommitted){
            response.sendRedirect(common.URLConfig.getFullPath(common.URLConfig.SURL_account));
        }
        else{
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute(common.BeansConfig.rUser, rUser);
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_account_edit).forward(request, response);
        }
    }

   
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
        processRequest(request, response);
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
        
        //if the request is directed from /account, forward to edit
        if (request.getAttribute(common.URLConfig.isFrom(common.URLConfig.SURL_account)) != null){
            this.getServletContext().getRequestDispatcher(common.URLConfig.JURL_account_edit).forward(request, response);
        }
        else{
            this.processEdit(request, response);
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
