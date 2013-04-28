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

                    <form action="<%=common.URLConfig.getFullPath(common.URLConfig.SURL_account)%>" method="POST" class="formInfoControl">
                        <a type="submit" class="btn">Edit</a>
                    </form>

                </div>

                <div class="formInfoContainer">
                    <c:forEach items="${rBookingCol.allBooking}" var="booking">
                        <%
                            beans.RMovieShow movieShow = new beans.RMovieShow();
                            movieShow.setMovieShowID(booking.getMovieShowID());
                            movieShow.fetchDBData();
                            request.setAttribute("movieShow", movieShow);
                            beans.RMovie movie = new beans.RMovie();
                            movie.setMovieID(movieShow.getMovieID());
                            movie.fetchDBData();
                            request.setAttribute("movie", movie);
                        %>
                        <form action="account" method="POST" class="formInfoControl">
                            <span class="infoLabel span1">${booking.bookingID}</span>
                            <span class="infoLabel span3">${movie.movieName}</span>
                            <span class="infoLabel span3">${movieshow.movieShowStartDate}-${movieShow.movieSHowStartTime}</span>
                            <span class="infoLabel span1">${booking.numOfTicket}</span>
                            <span class="infoLabel span2">${booking.paymentStatus}</span>
                            <br />
                            <c:if test="${!booking.isLoyaltyPaid}">
                                <a class="btn noLanguageOption" type="submit">Refund</a>
                            </c:if>
                            <c:if test="${!booking.isIncomplete}">
                                <a class="btn noLanguageOption" type="submit">Pay</a>
                            </c:if>
                        </form>        
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
