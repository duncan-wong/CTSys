<%-- 
    Document   : login
    Created on : Apr 9, 2013, 1:01:57 PM
    Author     : DUNCAN
--%>

<jsp:useBean id="rLogin" type="beans.RLogin" scope="request"></jsp:useBean>

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
                    <h1 class="headerMainTitle">${sLanguageBean.hLoginMainTitle()}</h1>
                    <div class="headerControl">
                        <span>
                            ${sLanguageBean.hLoginControlMsg()}
                        </span>
                        <a class="btn" href="<%= request.getServletPath() %>/signUp">
                            ${sLanguageBean.hLoginControlBtnSignUp()}
                        </a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <form action="j_security_check" method="post" class="formInfoContainer">
                    <%
                        if (((beans.RLogin)request.getAttribute(common.BeansConfig.rLogin)).getErrorMessage() != null){
                    %>
                        <div class="formInfoControl">
                            <p class="error">
                                ${rLogin.errorMessage}
                            </p>
                        </div>
                    <% } %>
                    
                    <div class="formInfoControl">
                        <label class="label">${sLanguageBean.cLoginLbUsername()}: </label>
                        <input type="text" class="infoInput" name="j_username" id="txtUserName" placeholder="Username" />
                    </div>
                    <div class="formInfoControl">
                        <label class="label">${sLanguageBean.cLoginLbPassword()}: </label>
                        <input type="password" class="infoInput" name="j_password" id="txtPassword" placeholder="Password" />
                    </div>
                    <div class="formInfoControl">
                        <input type="submit" class="btn" value="${sLanguageBean.cLoginBtnSubmit()}" />
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
