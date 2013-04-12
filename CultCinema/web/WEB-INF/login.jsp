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
        
<<<<<<< HEAD:CultCinema/web/WEB-INF/login.jsp
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="js/base.js"></script>
=======
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
>>>>>>> development-backup:CultCinema/web/WEB-INF/login.jsp
        
        <link rel="stylesheet" type="text/css" href="css/login.css" />
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
                    <h1 class="headerMainTitle">Log In</h1>
                    <div class="headerControl">
                        <span>Not a member?</span>
                        <a class="btn">Sign UP!</a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <form action="j_security_check" method="post" class="loginForm">
                    <%
                        if (((beans.RLogin)request.getAttribute(common.BeansConfig.rLogin)).getErrorMessage() != null){
                    %>
                        <div class="loginControl">
                            <p class="error">
                                <jsp:getProperty name="rLogin" property="errorMessage"></jsp:getProperty>
                            </p>
                        </div>
                    <% } %>
                    
                    <div class="loginControl">
                        <label class="label">Username: </label>
                        <input type="text" name="j_username" id="txtUserName" placeholder="Username" />
                    </div>
                    <div class="loginControl">
                        <label class="label">Password: </label>
                        <input type="password" name="j_password" id="txtPassword" placeholder="Password" />
                    </div>
                    <div class="loginControl">
                        <input type="submit" class="btn" value="Log In" />
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
