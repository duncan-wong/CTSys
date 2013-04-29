<%-- 
    Document   : mHouses
    Created on : Apr 29, 2013, 8:08:45 AM
    Author     : A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/houses.css" />
        
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
                        <%=sLanguageBean.hHousesMainTitle()%>
                    </h1>
                    <div class="headerControl">
                        <a href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Houses_create)%>" class="btn">
                            <%=sLanguageBean.cHousesBtnAddHouse()%>
                        </a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div class="houseContentGroup">
                    <%
                        request.setAttribute("houseCol", request.getAttribute(common.BeansConfig.rHouseCol));
                    %>
                    <%@include file="/WEB-INF/jspf/manager/mHouses.jspf" %>
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
