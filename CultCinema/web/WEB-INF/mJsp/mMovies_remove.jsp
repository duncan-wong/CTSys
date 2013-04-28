<%-- 
    Document   : movies_remove
    Created on : Apr 27, 2013, 7:26:35 PM
    Author     : A
--%>

<jsp:useBean id="rMovie" type="beans.RMovie" scope="request"></jsp:useBean>
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
                        <%="Movies"%>
                    </h1>
                </div>
            </div>

            <div id="content" class="defaultWidth">
                <div class="movieContentGroup">
                    <form action="<%=request.getContextPath() + common.URLConfig.SURLm_Movies_remove%>?movieId=${rMovie.movieID}" method="POST" class="formInfoContainer">

                            <div class="formInfoControl">
                                <span class="contentTitle">
                                    ${rMovie.movieName}
                                </span>
                            </div>
                            <div class="formInfoControl">
                                <span class="label">
                                    <%=sLanguageBean.cMoviesLbDirector()%>: 
                                </span>
                                <span class="content">
                                    ${rMovie.movieAuthor}
                                </span>
                            </div>
                            <div class="formInfoControl">
                                <span class="label">
                                    <%=sLanguageBean.cMoviesLbLength()%>: 
                                </span>
                                <span class="content">
                                    ${rMovie.movieDuration} mins
                                </span>
                            </div>
                            <div class="formInfoControl">
                                <span class="label">
                                    <%="Movie Time"%>: 
                                </span>
                                <span class="content dateContent">
                                    ${rMovie.movieStartDate} - ${rMovie.movieEndDate}
                                </span>
                            </div>
                            <div class="formInfoControl">
                                <span class="label">
                                    <%=sLanguageBean.cMoviesLbDescription()%>: 
                                </span>
                                <p class="content">
                                    ${rMovie.movieDescription}
                                </p>
                            </div>
                                
                        <div class="formInfoControl">
                                <a type="submit" class="btn noLanguageOption">Confirm Delete</a>
                                <a class="btn noLanguageOption" href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Movies)%>">Cancel</a>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>