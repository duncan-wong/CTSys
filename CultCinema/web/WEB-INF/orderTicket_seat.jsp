<%-- 
    Document   : orderTicket_time
    Created on : Apr 15, 2013, 10:31:39 PM
    Author     : DUNCAN
--%>

<jsp:useBean id="rCurrentMovie" type="beans.RMovie" scope="request"></jsp:useBean>
<jsp:useBean id="rMovieShow" type="beans.RMovieShow" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/houseSeat.css" />
        <script src="<%=request.getContextPath()%>/js/houseSeatPlan.js"></script>
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
                        <%=sLanguageBean.hOTMainTitle() %>
                    </h1>
                    
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <h2 class="contentTitle">${rCurrentMovie.movieName}</h2>
                <div class="formInfoContainer">
                    <div class="formInfoControl">
                        <span class="infoLabel">
                            House ${rMovieShow.houseID}
                        </span>
                        <span class="infoLabel">
                            - ${rMovieShow.movieShowStartDate}
                        </span>
                        <span class="infoLabel">
                            ${rMovieShow.movieShowStartTime}
                        </span>
                    </div>
                    <div class="formInfoControl">
                        <span class="infoLabel">
                            <%=sLanguageBean.comHKD() %> ${rMovieShow.ticketPrice}
                        </span>
                    </div>
                </div>
                
                <c:if test="${errorMsg != null}">
                    <span class="error">
                        ${errorMsg["purchaseError"]}
                    </span>
                </c:if>
                <form class="formInfoContainer" action="<%=request.getContextPath()%>/orderTicket?movieId=${rCurrentMovie.movieID}" method="POST">
                    <c:set var="houseSeats" scope="page" value="${houseSeats}" />
                    <div class="houseSeatPlanContainer">
                        <div class="houseScreen">
                            <%=sLanguageBean.comScreen() %>
                        </div>
                        
                        <table class="houseSeatPlan">
                            <c:forEach var="row" items="${rHouse.allSeats}">
                                <tr class="houseRow">
                                    <td class="houseRowId">
                                        ${row[0].rowID}
                                    </td>
                                    <c:forEach var="seat" items="${row}">
                                        <td id="${seat.rowNum}-${seat.seatNum}" class="houseSeat" status="${seat.seatStatus}" seatId="${seat.seatIdInRow}">
                                        </td>
                                    </c:forEach>
                                    <td class="houseRowId">
                                        ${row[0].rowID}
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <input type="hidden" name="selectedSeats" id="txtSelectedSeat" value="${selectedSeatsId}" />
                    </div>
                    <div class="formInfoControl">
                        <a class="btn noLanguageOption" type="submit_orderTicket"><%=sLanguageBean.comOrder() %></a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%>/orderTicket?movieId=${rCurrentMovie.movieID}"><%=sLanguageBean.comBack() %></a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>

