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
    public static final String SURL_orderTicketCancel = "/orderTicket/cancel";
    public static final String SURL_signUp = "/signUp";
    public static final String SURL_houses = "/houses";
    //officer
    public static final String SURLo_officer = "/officer";
    public static final String SURLo_refund = "/officer/refund";
    public static final String SURLo_refundApproved = "/officer/refundApproved";
    public static final String SURLo_refundDeclined = "/officer/refundDeclined";
    public static final String SURLo_checkout = "/officer/checkout";
    public static final String SURLo_checkoutCancel = "/officer/checkoutCancel";
    public static final String SURLo_checkoutPay = "/officer/checkoutPay";
    //servlet - manager
    public static final String SURLm_Manager = "/manager";
    public static final String SURLm_Movies = "/manager/movies";
    public static final String SURLm_Movies_edit = "/manager/movies/edit";
    public static final String SURLm_Movies_create = "/manager/movies/create";
    public static final String SURLm_Movies_remove = "/manager/movies/remove";
    public static final String SURLm_MovieShow = "/manager/movies/movieShow";
    public static final String SURLm_MovieShow_edit = "/manager/movies/movieShow/edit";
    public static final String SURLm_MovieShow_create = "/manager/movies/movieShow/create";
    public static final String SURLm_MovieShow_remove = "/manager/movies/movieShow/remove";
    
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
    public static final String JURL_orderTicket_thankYou = "/WEB-INF/orderTicket_thankYou.jsp";
    public static final String JURL_signUp = "/WEB-INF/account_create.jsp";
    public static final String JURL_houses = "/WEB-INF/houses.jsp";
    public static final String JURL_search = "/WEB-INF/search.jsp";
    //jsp - manager
    public static final String JURLm_Manage = "/WEB-INF/mJsp/mManage.jsp";
    public static final String JURLm_Movies = "/WEB-INF/mJsp/mMovies.jsp";
    public static final String JURLm_Movies_edit = "/WEB-INF/mJsp/mMovies_edit.jsp";
    public static final String JURLm_Movies_remove = "/WEB-INF/mJsp/mMovies_remove.jsp";
    public static final String JURLm_Movies_create = "/WEB-INF/mJsp/mMovies_create.jsp";
    public static final String JURLm_MovieShow = "/WEB-INF/mJsp/mMovieShow.jsp";
    public static final String JURLm_MovieShow_create = "/WEB-INF/mJsp/mMovieShow_create.jsp";
    public static final String JURLm_MovieShow_edit = "/WEB-INF/mJsp/mMovieShow_edit.jsp";
    public static final String JURLm_MovieShow_remove = "/WEB-INF/mJsp/mMovieShow_remove.jsp";
    //jsp - o
    public static final String JURLo_manage = "/WEB-INF/oJsp/oManage.jsp";
    public static final String JURLo_refund = "/WEB-INF/oJsp/oRefund.jsp";
    public static final String JURLo_checkout = "/WEB-INF/oJsp/oCheckout.jsp";
    

}
