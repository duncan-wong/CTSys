<%-- 
    Document   : movies
    Created on : Apr 13, 2013, 12:00:54 PM
    Author     : DUNCAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="css/movies.css" />
        
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
                    <h1 class="headerMainTitle">Movies</h1>
                    <div class="headerControl">
                        <span class="btn btnContentControl" contentGroup="movieContentGroup" contentGroup_target="movieOnScreen">
                            Movie On Screen
                        </span>
                        
                        <span class="btn btnContentControl" contentGroup="movieContentGroup" contentGroup_target="movieTomorrow">
                            Movie Tomorrow
                        </span>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div class="movieContentGroup movieOnScreen">
                    <h2 class="contentTitile">Movies On Screen</h2>
                    <%@include file="/WEB-INF/jspf/movies/movies.jspf" %>
                </div>
                <div class="movieContentGroup movieTomorrow">
                    <h2 class="contentTitile">Movie tomorrow</h2>
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
