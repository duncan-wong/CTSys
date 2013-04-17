<%-- 
    Document   : orderTicket_time
    Created on : Apr 15, 2013, 10:31:39 PM
    Author     : DUNCAN
--%>

<jsp:useBean id="rCurrentMovie" type="beans.RMovie" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movies.css" />
        
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
                        Order ticket
                    </h1>
                    
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div id="MovieID" class="movieContainer">

                    <img src="<%=request.getContextPath()%>/moviePoster/${currentMovie.movieID}.jpg" class="moviePoster" alt="Image not found">
                    <div class="movieDescription">
                        <div class="movieDescriptionItem">
                            <span class="movieTitle">
                                ${rCurrentMovie.movieName}
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cMoviesLbAuthor()%>: 
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
                                ${rCurrentMovie.movieDuration}
                            </span>
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
                    
                </div>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>

