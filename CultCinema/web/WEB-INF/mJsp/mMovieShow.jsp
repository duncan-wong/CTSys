<%-- 
    Document   : mManage_movieShow
    Created on : Apr 26, 2013, 9:37:17 PM
    Author     : A
--%>

<jsp:useBean id="rCurrentMovie" type="beans.RMovie" scope="request"></jsp:useBean>
<jsp:useBean id="rHouseCol" type="beans.RHouseCol" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movie.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/movieShow.css" />
        
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
                        <%=sLanguageBean.hMoviesShowMainTitle()%>
                    </h1>
                    <div class="headerControl">
                        <a href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Movies)%>" class="btn">
                            <%=sLanguageBean.comBack()%>
                        </a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div id="movie${rCurrentMovie.movieID}" class="movieContainer">

                    <img src="<%=request.getContextPath()%>/moviePoster/${rCurrentMovie.movieID}.jpg" class="moviePoster" alt="Image not found">
                    <div class="movieDescription">
                        <div class="movieDescriptionItem">
                            <span class="movieTitle">
                                ${rCurrentMovie.movieName}
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cMoviesLbDirector()%>: 
                            </span>
                            <span class="content">
                                ${rCurrentMovie.movieAuthor}
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cMoviesLbLength()%>: 
                            </span>
                            <span class="content">
                                ${rCurrentMovie.movieDuration} <%=sLanguageBean.comMins()%>
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cMoviesLbOnScreenTime()%>: 
                            </span>
                            <p class="content dateContent">
                                ${rCurrentMovie.movieStartDate} - ${rCurrentMovie.movieEndDate}
                            </p>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cMoviesLbDescription()%>: 
                            </span>
                            <p class="content">
                                ${rCurrentMovie.movieDescription}
                            </p>
                        </div>
                    </div>
                            
                    
                    <div class="movieControl">
                        <div class="formInfoControl">
                            <a class="btn" href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_MovieShow_create)%>?movieId=${rCurrentMovie.movieID}&duration=${rCurrentMovie.movieDuration}"><%=sLanguageBean.cMoviesShowBtnAddShow()%></a>
                        </div>
                    </div>
                </div>
                            
                <div id="movieShows">
                    <c:set var="movie" value="${rCurrentMovie}" scope="page" />
                    <c:forEach items="${rHouseCol.allHouse}" var="house">
                        <%@include file="/WEB-INF/jspf/manager/mMovieShow.jspf" %>
                    </c:forEach>
                </div>
                    
            </div>
                    
                    
                    
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
