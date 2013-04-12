<%-- 
    Document   : error
    Created on : Apr 11, 2013, 7:30:40 PM
    Author     : 52593578
--%>

<<<<<<< HEAD
<jsp:useBean id="sStatus" type="beans.SStatus" scope="session"></jsp:useBean>
=======
>>>>>>> development-backup
<jsp:useBean id="rError" type="beans.RError" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<<<<<<< HEAD
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cult Cinema</title>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="./js/base.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/base.css" />
=======
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
>>>>>>> development-backup
        
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
                <div class="headerWrapper defaultWidth">
                    <h1 class="headerMainTitle"> 
                        <jsp:getProperty name="rError" property="errorCode"></jsp:getProperty>
                    </h1>
                    <div class="headerSubTitle">
                        - <jsp:getProperty name="rError" property="errorMessage"></jsp:getProperty>
                    </div>
                    <div class="headerControl">
                        <a class="btn" href="index">Home</a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
