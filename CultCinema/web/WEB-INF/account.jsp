<%-- 
    Document   : account
    Created on : Apr 11, 2013, 5:25:58 PM
    Author     : 52593578
--%>

<jsp:useBean id="rUser" type="beans.RUser" scope="request"></jsp:useBean>
<jsp:useBean id="rBookingCol" type="beans.RBookingCol" scope="request"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>

        <link rel="stylesheet" type="text/css" href="css/account.css" />

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
                        <%=sLanguageBean.hAccountMainTitle()%>
                    </h1>
                    <div class="headerControl">
                        <span>
                            ${rUser.userName}, <%=sLanguageBean.hAccountControlMsg()%>
                        </span>
                    </div>
                </div>
            </div>

            <div id="content" class="defaultWidth">
                <div class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbUsername()%>: 
                        </label>
                        <span class="infoLabel">
                            ${rUser.loginID}
                        </span>
                    </div>

                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbName()%>: 
                        </label>
                        <span class="infoLabel">
                            ${rUser.userName}
                        </span>
                    </div>

                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbTel()%>: 
                        </label>
                        <span class="infoLabel">
                            ${rUser.userPhone}
                        </span>
                    </div>

                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbEmail()%>: 
                        </label>
                        <span class="infoLabel">
                            ${rUser.userEmail}
                        </span>
                    </div>
                        
                    <c:if test="${sStatus.isLoggedIn && sStatus.isCustomer}">    
                        <div class="formInfoControl">
                            <span class="label">
                                Loyalty point: 
                            </span>
                            <span class="infoLabel">
                                <c:out default="0" value="${rUser.loyalty}" />
                            </span>
                        </div>
                    </c:if>

                    <form action="<%=common.URLConfig.getFullPath(common.URLConfig.SURL_account)%>" method="POST" class="formInfoControl">
                        <a type="submit" class="btn">Edit</a>
                    </form>

                </div>

                <div class="formInfoContainer">
                    <c:if test="${errorMsg != null}">
                        <span class="error">
                            ${errorMsg["refundError"]}
                        </span>
                    </c:if>
                    
                    <c:forEach items="${rBookingCol.allBooking}" var="booking">
                        <c:set var="booking" value="${booking}" scope="request" />
                        <%
                            beans.RBooking booking = (beans.RBooking)request.getAttribute("booking");
                            beans.RMovieShow movieShow = new beans.RMovieShow();
                            movieShow.setMovieShowID(booking.getMovieShowID());
                            movieShow.fetchDBData();
                            request.setAttribute("movieShow", movieShow);
                            beans.RMovie movie = new beans.RMovie();
                            movie.setMovieID(movieShow.getMovieID());
                            movie.fetchDBData();
                            request.setAttribute("movie", movie);
                            
                            request.setAttribute("isRefundPossible", booking.isBeforeHours(3));
                        %>
                        <div class="formInfoControl border_bottom">
                            <span class="infoLabel">${movieShow.movieShowStartTime}</span>
                            <span class="infoLabel span3">${movie.movieName}</span>
                            <span class="infoLabel span3">House ${movieShow.houseID}: ${movieShow.movieShowStartDate}-${movieShow.movieShowStartTime}</span>
                            <span class="infoLabel span1">${booking.numOfTicket}</span>
                            <span class="infoLabel span2">${booking.paymentStatus}</span>
                            <br />
                            <span class="infoLabel span4">Booking made at: ${booking.bookingMadeDate}-${booking.bookingMadeTime}</span>
                            <c:if test="${booking.isComplete && isRefundPossible}">
                                <a class="btn noLanguageOption" href="orderTicket/refund?bid=${booking.bookingID}">Refund</a>
                            </c:if>
                            <c:if test="${booking.isDeferred || booking.isRefundAccepted}">
                                <a class="btn noLanguageOption" href="orderTicket/cancel?bid=${booking.bookingID}&next=account">Cancel</a>
                            </c:if>
                        </div>        
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
