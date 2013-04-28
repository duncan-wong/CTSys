<%-- 
    Document   : movies_edit
    Created on : Apr 27, 2013, 7:18:44 PM
    Author     : A
--%>

<jsp:useBean id="rMovie" type="beans.RMovie" scope="request"></jsp:useBean>
<%--<jsp:useBean id="sLanguageBean" type="beans.accessInterface.LanguageBean" scope="session"></jsp:usebean>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movies.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/movies.css" />
        <!-- jQuery datepicker -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datepick.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.datepick.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#popupDatepicker').datepick({dateFormat: 'yyyy.mm.dd'});
                $('#popupDatepicker2').datepick({dateFormat: 'yyyy.mm.dd'});
            });
        </script>
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
                        <%="Movies"%>
                    </h1>
                </div>
            </div>

            <div id="content" class="defaultWidth">
                <c:if test="${errorMsg != null}">
                    <span class="error">
                        ${errorMsg["pageError"]}
                    </span>
                </c:if>   

                <form action="<%=request.getContextPath() + common.URLConfig.SURL_m_Movies_edit%>?movieId=${rMovie.movieID}" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%="Movie Name"%>: 
                        </label>
                        <input type="text" name="movieName" class="infoInput span5" value="${rMovie.movieName}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["movieName"]}
                            </span>
                        </c:if>
                    </div>

                    <div class="formInfoControl">
                        <label class="label">
                            <%="Director"%>: 
                        </label>
                        <input type="text" name="movieAuthor" class="infoInput span5" value="${rMovie.movieAuthor}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["movieAuthor"]}
                            </span>
                        </c:if>
                    </div>

                    <div class="formInfoControl">
                        <label class="label">
                            <%="Length (mins)"%>: 
                        </label>
                        <input type="text" name="movieDuration" class="infoInput span5" value="${rMovie.movieDuration}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["movieDuration"]}
                            </span>
                        </c:if>
                    </div>


                    <div class="formInfoControl">
                        <label class="label">
                            <%="On Screen Date"%>: 
                        </label>
                        <input type="text" name="movieStartDate" class="infoInput dateInput span2" id="popupDatepicker" value="${rMovie.movieStartDate}" />
                        <span class="infoSeparator">-</span>
                        <input type="text" name="movieEndDate" class="infoInput dateInput span2" id="popupDatepicker2" value="${rMovie.movieEndDate}" />
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
                        <textarea name="movieDescription" class="infoInputArea span5">${rMovie.movieDescription}</textarea>
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
                        <a type="submit" class="btn noLanguageOption">Save</a>
                        <a class="btn noLanguageOption" href="<%=common.URLConfig.getFullPath(common.URLConfig.SURL_m_Movies)%>">Cancel</a>
                    </div>
                </form>
            </div>
        </div>

        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>