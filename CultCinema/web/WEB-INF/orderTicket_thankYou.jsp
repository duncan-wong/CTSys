<%-- 
    Document   : orderTicket_info
    Created on : Apr 25, 2013, 2:47:45 AM
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
                        Order ticket - Thank you!
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
                            HKD ${rMovieShow.ticketPrice}
                        </span>
                    </div>
                        
                    <div class="formInfoControl">
                        <span class="label">Seats: </span>
                        <c:forEach items="${rBooking.bookedSeat}" var="seat">
                            <span class="houseSeat seat_select">
                                &nbsp-&nbsp${seat.seatID}&nbsp-&nbsp&nbsp
                            </span>
                        </c:forEach>
                    </div>
                        
                    <div class="formInfoControl">
                        <c:set var="total" value="${rMovieShow.ticketPrice * sBooking.numOfTicket}" scope="page" />
                        <span class="label">
                            Total: 
                        </span>
                        <span class="infoLabel">
                            HKD ${total}
                        </span>
                    </div>
                </div>
                
                    <div class="formInfoControl">
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%>/movies">Other movies</a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%>/orderTicketCancel">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>

