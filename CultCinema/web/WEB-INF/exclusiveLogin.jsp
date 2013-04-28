<%-- 
    Document   : exclusiveLogin
    Created on : Apr 28, 2013, 9:27:58 PM
    Author     : DUNCAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
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
                    <h1 class="headerMainTitle"><%=sLanguageBean.hLoginMainTitle()%></h1>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div class="formInfoContainer">
                    <div class="formInfoControl">
                        <span class="infoLabel error">
                            <%=sLanguageBean.cELoginLbStatus() %>
                        </span>
                    </div>
                    
                    <div class="formInfoControl">
                        <span class="infoLabel">
                            <%=sLanguageBean.cELoginLbInstruction() %>
                        </span>
                        <a class="btn" href="<%=request.getContextPath()%>/exclude/exclusiveLogin">
                            <%=sLanguageBean.cELoginBtnForceOther() %>
                        </a>
                        <a class="btn" href="<%=request.getContextPath()%>/exclude/logout">
                            <%=sLanguageBean.cELoginBtnLogoutHere() %>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
