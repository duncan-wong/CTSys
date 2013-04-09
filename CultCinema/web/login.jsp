<%-- 
    Document   : login
    Created on : Apr 9, 2013, 1:01:57 PM
    Author     : DUNCAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cult Cinema</title>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="./js/base.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/base.css" />
    </head>
    <body>
        <div class="asgClaim_stayTop scrollLeft">
            <%@include file="WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
        
        
        <div id="mainContainer">
            <div id="menu" class="scrollLeft">
                <%@include file="WEB-INF/jspf/common/menu.jspf" %>
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
                <form action="login" method="post">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" id="txtUserName" placeholder="Username" />
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" id="txtPassword" placeholder="Password" />
                    </div>
                    <div>
                        <input type="submit" class="btn" />
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
