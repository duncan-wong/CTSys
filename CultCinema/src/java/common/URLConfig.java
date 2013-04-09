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
    
    //jsp
    public static final String JURL_index = "/index.jsp";
    public static final String JURL_login = "/login.jsp";
}
