<%-- 
    Document   : movies_create
    Created on : Apr 27, 2013, 7:26:26 PM
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
    <!-- jQuery datepicker -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datepick.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.datepick.js"></script>
        <script type="text/javascript">
        $(function() {
            $('#popupDatepicker').datepick({dateFormat: 'yyyy.mm.dd'});
        });
        </script>
        
    <!-- jQuery timepicker -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.timeentry.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.timeentry.js"></script>
    <!---->
        
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
                <c:if test="${errorMsg != null}">
                    <span class="error">
                        ${errorMsg["pageError"]}
                    </span>
                </c:if>   
                    
                <form action="<%=common.URLConfig.getFullPath(common.URLConfig.SURL_m_Movies_create)%>" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%="House ID"%>: 
                        </label>
                            <input type="text" name="houseID" class="infoInput" value="${rMovieShow.houseID}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["houseID"]}
                            </span>
                        </c:if>
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%="Showing Time"%>: 
                        </label>
                        <input type="text" name="startDate" class="infoInput" id="popupDatepicker" value="${rMovieShow.movieShowStartDate}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["startDate"]}
                            </span>
                        </c:if>
                    </div>
                            
                    <div class="formInfoControl">
                        <label class="label">
                            <%="Length (mins)"%>: 
                        </label>
                            <input type="text" name="movieDuration" class="infoInput" value="${rMovieShow.movieShowStartTime}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["startTime"]}
                            </span>
                        </c:if>
                    </div>
                    
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%="On Screen Date"%>: 
                        </label>
                            <input type="text" name="movieStartDate" class="infoInput dateInput" id="popupDatepicker" value="${rMovieShow.movieStartDate}" />
                        <span class="infoSeparator">-</span>
                            <input type="text" name="movieEndDate" class="infoInput dateInput" id="popupDatepicker2" value="${rMovieShow.movieEndDate}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["movieDate"]}
                            </span>
                        </c:if>
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%="Description"%>: 
                        </label>
                            <textarea name="movieDescription" class="infoInputArea">${rMovieShow.movieDescription}</textarea>
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["movieDescription"]}
                            </span>
                        </c:if>
                    </div>
                            
                    <div class="formInfoControl">
                        <label class="label">
                            <%="Poster"%>: 
                        </label>
                            <input type="file" name="moviePoster" accept=".jpg" class="infoInput" />
                    </div>
                            
                    <div class="formInfoControl">
                        <a type="submit" class="btn noLanguageOption">Create</a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%>/manager/movies">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>