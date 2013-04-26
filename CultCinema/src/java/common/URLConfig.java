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
    
    //trace attribute key
    public static final String nextInternalUrl = "nextInternalUrl";
    
    //trace attribute or key
    public static String isFrom(String url){
        return "isFrom_" + url;
    }
    
    //context path
    public static final String ContextPath = "/CultCinema";
    
    //servlet
    public static final String SURL_index = "/index";
    public static final String SURL_login = "/login";
    public static final String SURL_login_user = "/login_user";
    public static final String SURL_loginError = "/loginError";
    public static final String SURL_logout = "/logout";
    public static final String SURL_account = "/account";
    public static final String SURL_account_edit = "/account/edit";
    public static final String SURL_movies = "/movies";
    public static final String SURL_orderTicket = "/orderTicket";
    public static final String SURL_orderTicket_member = "/orderTicket_member";
    public static final String SURL_signUp = "/signUp";
    public static final String SURL_houses = "/houses";
    
    //jsp
    public static final String JURL_index = "/WEB-INF/index.jsp";
    public static final String JURL_login = "/WEB-INF/login.jsp";
    public static final String JURL_account = "/WEB-INF/account.jsp";
    public static final String JURL_account_edit = "/WEB-INF/account_edit.jsp";
    public static final String JURL_error = "/WEB-INF/error.jsp";
    public static final String JURL_movies = "/WEB-INF/movies.jsp";
    public static final String JURL_orderTicket_time = "/WEB-INF/orderTicket_time.jsp";
    public static final String JURL_orderTicket_seat = "/WEB-INF/orderTicket_seat.jsp";
    public static final String JURL_orderTicket_info = "/WEB-INF/orderTicket_info.jsp";
    public static final String JURL_signUp = "/WEB-INF/account_create.jsp";
    public static final String JURL_houses = "/WEB-INF/houses.jsp";
    public static final String JURL_search = "/WEB-INF/search.jsp";
    //jsp - m
    public static final String JURLm_Manage = "/WEB-INF/mJsp/mManage.jsp";
    public static final String JURLm_Officer = "/WEB-INF/mJsp/mOfficer.jsp";
}
