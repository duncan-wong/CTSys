<%-- 
    Document   : account
    Created on : Apr 11, 2013, 5:25:58 PM
    Author     : 52593578
--%>

<jsp:useBean id="rUser" type="beans.RUser" scope="request"></jsp:useBean>
<%--<jsp:useBean id="sLanguageBean" type="beans.accessInterface.LanguageBean" scope="session"></jsp:usebean>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="css/account.css" />
        
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
                        <%= sLanguageBean.hAccountMainTitle()  %>
                    </h1>
                    <div class="headerControl">
                        <span>
                            <jsp:getProperty name="sStatus" property="userName"></jsp:getProperty>, <%= sLanguageBean.hAccountControlMsg()  %>
                        </span>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div class="infoContainer">
                    <div class="info">
                        <label class="label">
                            <%= sLanguageBean.cAccountLbUsername()  %>: 
                        </label>
                        <span>
                            <jsp:getProperty name="rUser" property="userId"></jsp:getProperty>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
