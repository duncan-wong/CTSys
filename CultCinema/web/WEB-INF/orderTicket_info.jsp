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
                        Order ticket
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
                </div>
                
                <%-- non-member --%>
                <c:if test="${!sStatus.isLoggedIn}">
                    <form action="<%=request.getContextPath()%>/orderTicket_member?movieId=${rCurrentMovie.movieID}"
                          method="POST"
                          class="formInfoContainer">
                        <span class="infoLabel">Are you a member?</span>
                        <a class="btn noLanguageOption" type="submit">Log In</a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%><%=common.URLConfig.SURL_signUp%>" target="blank">Sign Up!</a>
                    </form>
                </c:if>
                <form action="<%=request.getContextPath()%>/orderTicket?movieId=${rCurrentMovie.movieID}" method="POST" class="formInfoContainer">
                    <%-- non-member purchase --%>
                    <c:if test="${!sStatus.isLoggedIn}">
                       <div class="formInfoControl">
                           <span class="infoLabel">
                               Non-member purchase
                           </span>
                       </div>
                       <div class="formInfoControl">
                           <span class="label">Email: </span>
                           <input id="txtEmail" name="non-member_email" type="text" class="infoInput" />
                       </div>
                       <div class="formInfoControl">
                           <span class="label">Credit card no.: </span>
                           <input id="txtCreditCardNo" name="non-member_creditCardNo" type="text" class="infoInput" />
                       </div>
                       <div class="formInfoControl">
                           <span class="label">Credit card safe no.: </span>
                           <input id="txtCreditCardNo" name="non-member_creditCardSafeNo" type="text" class="infoInput" />
                       </div>
                    </c:if>
                
                
                    <%-- member --%>
                    <c:if test="${sStatus.isLoggedIn}">
                        <div class="formInfoControl">
                            <span class="label">Credit card no.: </span>
                            <input id="txtCreditCardNo" name="member_creditCardNo" type="text" class="infoInput" />
                        </div>
                        <div class="formInfoControl">
                            <span class="label">Credit card safe no.: </span>
                            <input id="txtCreditCardNo" name="member_creditCardSafeNo" type="text" class="infoInput" />
                        </div>
                    </c:if>
                    
                    <div class="formInfoControl">
                        <span class="label">Seats: </span>
                        <c:forEach items="${sBooking.selectedTickets}" var="seat">
                            <span class="houseSeat seat_select">
                                ${seat.seatID}
                            </span>
                        </c:forEach>
                    </div>
                  
                    <div class="formInfoControl">
                        <a class="btn noLanguageOption" type="submit">Purchase</a>
                        <a class="btn noLanguageOption" type="submit_backward">Back</a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>

