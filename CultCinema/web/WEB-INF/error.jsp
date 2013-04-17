<%-- 
    Document   : error
    Created on : Apr 11, 2013, 7:30:40 PM
    Author     : 52593578
--%>

<jsp:useBean id="rError" type="beans.RError" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
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
                        ${rError.errorCode}
                    </h1>
                    <div class="headerSubTitle">
                        - ${rError.errorMessage}
                    </div>
                    <div class="headerControl">
                        <a class="btn" href="<%=request.getContextPath()%>/index">Home</a>
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
