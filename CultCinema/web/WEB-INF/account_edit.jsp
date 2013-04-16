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
        
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/account.css" />
        
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
                <form action="account/edit" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%= sLanguageBean.cAccountLbUsername()  %>: 
                        </label>
                        <span class="infoLabel">
                            <jsp:getProperty name="rUser" property="loginID"></jsp:getProperty>
                        </span>
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%= sLanguageBean.cAccountLbName() %>: 
                        </label>
                        <span class="infoLabel">
                            <jsp:getProperty name="rUser" property="userName"></jsp:getProperty>
                        </span>
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%= sLanguageBean.cAccountLbTel()  %>: 
                        </label>
                        <input type="text" name="phone" class="infoInput" value="<jsp:getProperty name="rUser" property="userPhone"></jsp:getProperty>" />
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%= sLanguageBean.cAccountLbEmail()  %>: 
                        </label>
                        <input type="text" name="email" class="infoInput" value="<jsp:getProperty name="rUser" property="userEmail"></jsp:getProperty>" />
                    </div>
                        
                    <div class="formInfoContainer">
                        <input type="submit" class="btn" value="Save" />
                        <a class="btn noLanguageOption" href="<%= request.getContextPath() %>/account">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
