/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DUNCAN
 */
public abstract class URLConfig {
    //add context path
    public static String getFullPath(String partUrl){
        return ContextPath + partUrl;
    }
    
    //context path
    public static final String ContextPath = "/CultCinema";
    
    //servlet
    public static final String SURL_index = "/index";
    public static final String SURL_login = "/login";
    public static final String SURL_loginError = "/loginError";
    public static final String SURL_logout = "/logout";
    
    //jsp
    public static final String JURL_index = "/WEB-INF/index.jsp";
    public static final String JURL_login = "/WEB-INF/login.jsp";
    public static final String JURL_account = "/WEB-INF/account.jsp";
    public static final String JURL_error = "/WEB-INF/error.jsp";
    //jsp - m
    public static final String JURL_mManage = "/WEB-INF/mJsp/mManage.jsp";
}
