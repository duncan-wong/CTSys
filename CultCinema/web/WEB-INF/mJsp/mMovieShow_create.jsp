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
        <!-- jQuery timepicker -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.timeentry.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.timeentry.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.mousewheel.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#popupDatepicker').datepick({dateFormat: 'yyyy.mm.dd'});
                $('#timepicker').timeEntry({show24Hours: true, useMouseWheel: true});
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

                <form action="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_MovieShow_create)%>" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%="House"%>: 
                        </label>
                        <%
                            beans.RHouseCol rHouseCol = new beans.RHouseCol();
                            rHouseCol.fetchDBData();
                            pageContext.setAttribute("rHouseCol", rHouseCol);
                        %>
                        <select class="infoInput" name="houseID">
                            <c:forEach items="${rHouseCol.allHouse}" var="house">
                                <option value="${house.houseID}" ${rMovieShow.houseID==house.houseID ? 'selected' : ''}>${house.houseName}| Capacity: ${house.houseCapacity}</option>
                            </c:forEach>
                        </select>
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
                        <input type="text" name="startDate" class="infoInput dateInput" id="popupDatepicker" value="${rMovieShow.movieShowStartDate}" />
                        <input type="text" name="startTime" class="infoInput span1" id="timepicker" value="${rMovieShow.movieShowStartTime==null ? '00:00' : rMovieShow.movieShowStartTime}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["startDate"]}
                            </span>
                        </c:if>
                    </div>

                    <div class="formInfoControl">
                        <label class="label">
                            <%="Ticket Price"%>:
                        </label>
                        <label class="infoInput">
                            HKD
                        </label>
                        <input type="text" name="ticketPrice" class="infoInput span1" value="${rMovieShow.ticketPrice}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["ticketPrice"]}
                            </span>
                        </c:if>
                    </div>

                    <div class="formInfoControl">
                        <a type="submit" class="btn noLanguageOption">Add</a>
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