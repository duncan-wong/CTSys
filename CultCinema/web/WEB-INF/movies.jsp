<%-- 
    Document   : movies
    Created on : Apr 13, 2013, 12:00:54 PM
    Author     : DUNCAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movies.css" />
        
    </head>
    <body>
        <div class="asgClaim_stayTop scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
        
        
        <div id="mainContainer">
            <div id="menu" class="scrollLeft">
                <%@include file="/WEB-INF/jspf/common/menu.jspf" %>
            </div>
            
            <div id="header" class="smallHeader">
                <div class="headerWrapper defaultWidth">
                    <h1 class="headerMainTitle">
                        ${sLanguageBean.hMoviesMainTitle()}
                    </h1>
                    <div class="headerControl">
                        <span class="btn btnContentControl" contentGroup="movieContentGroup" contentGroup_target="movieOnScreen">
                            ${sLanguageBean.hMoviesControlBtnOnScreen()}
                        </span>
                        
                        <span class="btn btnContentControl" contentGroup="movieContentGroup" contentGroup_target="movieTomorrow">
                            ${sLanguageBean.hMoviesControlBtnTomorrow()}
                        </span>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div class="movieContentGroup movieOnScreen">
                    <h2 class="contentTitile">
                        ${sLanguageBean.hMoviesControlBtnOnScreen()}
                    </h2>
                    <%
                        request.setAttribute("movieCol", request.getAttribute(common.BeansConfig.rMovieCol_onScreen));
                    %>
                    <%@include file="/WEB-INF/jspf/movies/movies.jspf" %>
                </div>
                <div class="movieContentGroup movieTomorrow inactiveContent">
                    
                    <h2 class="contentTitile">
                        ${sLanguageBean.hMoviesControlBtnTomorrow()}
                    </h2>
                    <%
                        request.setAttribute("movieCol", request.getAttribute(common.BeansConfig.rMovieCol_tomorrow));
                    %>
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
