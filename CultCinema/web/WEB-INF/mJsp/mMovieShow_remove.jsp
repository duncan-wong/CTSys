<%-- 
    Document   : movies_remove
    Created on : Apr 27, 2013, 7:26:35 PM
    Author     : A
--%>

<jsp:useBean id="rMovieShow" type="beans.RMovieShow" scope="request"></jsp:useBean>
<%--<jsp:useBean id="sLanguageBean" type="beans.accessInterface.LanguageBean" scope="session"></jsp:usebean>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>

        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/movies.css" />

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
                        <%="Movie Shows"%>
                    </h1>
                </div>
            </div>

            <div id="content" class="defaultWidth">

                <form action="<%=request.getContextPath() + common.URLConfig.SURLm_MovieShow_remove%>" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <span class="label">
                            Movie Show:
                        </span>
                        <span class="infoInput">
                            ${rMovieShow.movieShowStartDate} | ${rMovieShow.movieShowStartTime} | HKD ${rMovieShow.ticketPrice}
                        </span>
                    </div>

                    <div class="formInfoControl">
                        <a type="submit" class="btn noLanguageOption">Confirm Delete</a>
                        <a class="btn noLanguageOption" href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_MovieShow)%>?movieId=${movieId}">Cancel</a>
                    </div>

                </form>
            </div>
        </div>

        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>