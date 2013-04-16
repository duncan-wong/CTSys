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
    public static final String SURL_login_user = "/login_user";
    public static final String SURL_loginError = "/loginError";
    public static final String SURL_logout = "/logout";
    public static final String SURL_movies = "/movies";
    public static final String SURL_orderTicket = "/orderTicket";
    
    //jsp
    public static final String JURL_index = "/WEB-INF/index.jsp";
    public static final String JURL_login = "/WEB-INF/login.jsp";
    public static final String JURL_account = "/WEB-INF/account.jsp";
    public static final String JURL_error = "/WEB-INF/error.jsp";
    public static final String JURL_movies = "/WEB-INF/movies.jsp";
    public static final String JURL_orderTicket_time = "/WEB-INF/orderTicket_time.jsp";
    //jsp - m
    public static final String JURLm_Manage = "/WEB-INF/mJsp/mManage.jsp";
}
