<%-- 
    Document   : mManage_movie
    Created on : Apr 27, 2013, 4:36:44 PM
    Author     : A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movies.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/movies.css" />
        
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
                        <%=sLanguageBean.hMoviesMainTitle()%>
                    </h1>
                    <div class="headerControl">
                        <a href="<%=common.URLConfig.getFullPath(common.URLConfig.SURL_m_Movies_create)%>" class="btn">
                            <%="Add New Movie"%>
                        </a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div class="movieContentGroup">
                    <%
                        request.setAttribute("managerMovieCol", request.getAttribute("managerMovieCol"));
                    %>
                    <%@include file="/WEB-INF/jspf/manager/oneMovie.jspf" %>
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
