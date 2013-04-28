<%-- 
    Document   : mManage
    Created on : Apr 11, 2013, 6:40:58 PM
    Author     : 52593578
--%>

    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
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
                    <h1 class="headerMainTitle">Manager Page</h1>
                </div>
            </div>
            
            <div id="content" class="defaultWidth overflow_x_hidden">
                <a href="<%=common.URLConfig.getFullPath(common.URLConfig.SURL_m_Movies)%>" class="btn_large bottom_border">
                    <h1 class="contentTitle">MOVIES</h1>
                </a>
                <a class="btn_large bottom_border">
                    <h1 class="contentTitle">HOUSE</h1>
                </a>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>

