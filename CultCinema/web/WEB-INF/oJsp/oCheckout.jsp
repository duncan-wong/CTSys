<%-- 
    Document   : account
    Created on : Apr 11, 2013, 5:25:58 PM
    Author     : 52593578
--%>

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
                        Checkout
                    </h1>
                </div>
            </div>

            <div id="content" class="defaultWidth">

                <div class="formInfoContainer">
                    <c:if test="${errorMsg != null}">
                        <span class="error">
                            ${errorMsg["purchaseError"]}
                        </span>
                    </c:if>

                    <span class="infoLabel">
                        ${paymentMsg}
                    </span>

                    <c:if test="${rBookingCol.count == 0 && paymentMsg == null}">
                        <span class="infoLabel">
                            No purchase
                        </span>
                    </c:if>

                    <c:if test="${rBookingCol.count > 0}">
                        <a class="btn noLanguageOption" href="checkoutCancel">Cancel All</a>
                        <a class="btn noLanguageOption" href="checkoutPay">Pay All</a>
                    </c:if>

                    <c:forEach items="${rBookingCol.allBooking}" var="booking">
                        <c:set var="booking" value="${booking}" scope="request" />
                        <%
                            beans.RBooking booking = (beans.RBooking) request.getAttribute("booking");
                            beans.RMovieShow movieShow = new beans.RMovieShow();
                            movieShow.setMovieShowID(booking.getMovieShowID());
                            movieShow.fetchDBData();
                            request.setAttribute("movieShow", movieShow);
                            beans.RMovie movie = new beans.RMovie();
                            movie.setMovieID(movieShow.getMovieID());
                            movie.fetchDBData();
                            request.setAttribute("movie", movie);
                        %>
                        <div class="formInfoControl border_bottom">
                            <span class="infoLabel span3">${movie.movieName}</span>
                            <span class="infoLabel span3">House ${movieShow.houseID}: ${movieShow.movieShowStartDate}-${movieShow.movieShowStartTime}</span>
                            <span class="infoLabel span1">${booking.numOfTicket}</span>
                            <span class="infoLabel span2">${booking.paymentStatus}</span>
                            <br />
                            <span class="infoLabel span4">Booking made at: ${booking.bookingMadeDate}-${booking.bookingMadeTime}</span>
                            <c:if test="${booking.isDeferred}">
                                <a class="btn noLanguageOption" href="checkoutCancel?bid=${booking.bookingID}">Cancel</a>
                                <a class="btn noLanguageOption" href="checkoutPay?bid=${booking.bookingID}">Pay</a>
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
