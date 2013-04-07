<%-- 
    Document   : index
    Created on : Apr 7, 2013, 1:21:59 AM
    Author     : DUNCAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=300, initial-scale=1, maximum-scale=1">
        <title>Cult Cinema</title>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="./js/base.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/base.css" />
        
    </head>
    <body>
        <%@include file="WEB-INF/jspf/common/asgClaim.jspf" %>
        
        
        
        <div id="mainContainer">
            <div id="menu">
                <%@include file="WEB-INF/jspf/common/menu.jspf" %>
            </div>
            
            <div id="header">
                <%@include file="WEB-INF/jspf/common/header.jspf" %>
            </div>
            
            <div id="content">
                <%@include file="WEB-INF/jspf/movies/movies.jspf" %>
            </div>
        </div>
        
        <%@include file="WEB-INF/jspf/common/asgClaim.jspf" %>
    </body>
</html>
