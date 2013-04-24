<%-- 
    Document   : index
    Created on : Apr 7, 2013, 1:21:59 AM
    Author     : DUNCAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index.css" />
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
            
            <div id="header">
                <%@include file="/WEB-INF/jspf/common/header.jspf" %>
            </div>
            
            <div id="content" class="defaultWidth">
                <h2 class="contentTitle">
                   <%=sLanguageBean.cIndexContentTitle()%>
                </h2>
                <%
                    request.setAttribute("movieCol", request.getAttribute(common.BeansConfig.rMovieCol_onScreen));
                %>
                <%@include file="/WEB-INF/jspf/movies/movies.jspf" %>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
