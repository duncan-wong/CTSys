<%-- 
    Document   : mHouseSeat_edit
    Created on : Apr 29, 2013, 3:42:32 PM
    Author     : A
--%>

<jsp:useBean id="rHouse" type="beans.RHouse" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/houseSeat.css" />
        <script src="<%=request.getContextPath()%>/js/mHouseSeatPlan.js"></script>
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
                        <%=sLanguageBean.hHousesSeatMainTitle()%>
                    </h1>
                    
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <h2 class="contentTitle">${rCurrentMovie.movieName}</h2>
                <div class="formInfoContainer">
                    <div class="formInfoControl">
                        <span class="contentTitle">
                            ${rHouse.houseName}
                        </span>
                    </div>
                </div>
                <c:if test="${errorMsg != null}">
                    <span class="error">
                        ${errorMsg["pageError"]}
                    </span>
                </c:if>
                
                <form class="formInfoContainer" action="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_HouseSeat_edit)%>" method="POST">
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
                        <input type="hidden" name="selectedSeats_d" id="txtSelectedSeat_d" value="${selectedSeatsId_d}" />
                    </div>
                    <!---->
                    <div class="formInfoControl">
                        <a class="btn noLanguageOption" type="submit_orderTicket"><%=sLanguageBean.comSave()%></a>
                        <a class="btn noLanguageOption" href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Houses)%>"><%=sLanguageBean.comBack()%></a>
                    </div>
                    <!---->
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>