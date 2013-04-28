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
                        <%=sLanguageBean.hOTMainTitle() %>
                    </h1>
                    
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <h2 class="contentTitle">${rCurrentMovie.movieName}</h2>
                <div class="formInfoContainer">
                    <div class="formInfoControl">
                        <span class="infoLabel">
                            <%=sLanguageBean.comHouse() %> ${rMovieShow.houseID}
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
                        
                       
                    <div class="formInfoControl">
                        <span class="label"><%=sLanguageBean.comSeats() %>: </span>
                        <c:forEach items="${sBooking.selectedTickets}" var="seat">
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
                            <%=sLanguageBean.comHKD() %> ${total}
                        </span>
                    </div>
                    <c:if test="${sStatus.isLoggedIn && sStatus.isCustomer}">    
                        <div class="formInfoControl">
                            <span class="label">
                                <%=sLanguageBean.comLoyaltyPoint() %>: 
                            </span>
                            <span class="infoLabel">
                                <c:out default="0" value="${rUser.loyalty}" />
                            </span>
                        </div>
                    </c:if>
                </div>
                
                <%-- non-member --%>
                <c:if test="${!sStatus.isLoggedIn}">
                    <form action="<%=request.getContextPath()%>/orderTicket_member?movieId=${rCurrentMovie.movieID}"
                          method="POST"
                          class="formInfoContainer">
                        <span class="infoLabel"><%=sLanguageBean.cOTAreYouMember() %>? </span>
                        <a class="btn noLanguageOption" type="submit"><%=sLanguageBean.comLogIn() %></a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%><%=common.URLConfig.SURL_signUp%>" target="blank"><%=sLanguageBean.comSignUp() %></a>
                    </form>
                </c:if>
                <form action="<%=request.getContextPath()%>/orderTicket?movieId=${rCurrentMovie.movieID}" method="POST" class="formInfoContainer">
                    <%-- non-member purchase --%>
                    <c:if test="${!sStatus.isLoggedIn}">
                       <div class="formInfoControl">
                           <span class="infoLabel">
                               <%=sLanguageBean.cOTNonMemberPurchase() %>
                           </span>
                       </div>
                       <div class="formInfoControl">
                           <span class="label"><%=sLanguageBean.comEmail() %>: </span>
                           <input id="txtEmail" name="email" type="text" class="infoInput" value="${sBooking.guestEmail}" />
                           <c:if test="${errorMsg != null}">
                               <span class="error">
                                   ${errorMsg["email"]}
                               </span>
                           </c:if>
                       </div>
                    </c:if>
                    
                    <c:if test="${sStatus.isLoggedIn && sStatus.isCustomer && total <= rUser.loyalty_int}">
                        <div class="formInfoControl">
                            <span class="label">
                                <%=sLanguageBean.cOTUseLoyaltyPoint() %>?
                            </span>
                            <input type="checkbox" name="loyaltyPoint" value="loyaltyPoint" />
                        </div>
                    </c:if>
                    
                    <%-- common purchas information --%>
                    <c:if test="${sStatus.isCustomer}">
                        <div class="formInfoControl">
                            <span class="label"><%=sLanguageBean.cOTCreditCardNo() %>: </span>
                            <input id="txtCreditCardNo" name="creditCardNo" type="text" class="infoInput" />
                            <c:if test="${errorMsg != null}">
                                <span class="error">
                                    ${errorMsg["creditCardNo"]}
                                </span>
                            </c:if>
                        </div>
                        <div class="formInfoControl">
                            <span class="label"><%=sLanguageBean.cOTCreditCardSafeNo() %>: </span>
                            <input id="txtCreditCardNo" name="creditCardSafeNo" type="text" class="infoInput" />
                            <c:if test="${errorMsg != null}">
                                   <span class="error">
                                       ${errorMsg["creditCardSafeNo"]}
                                   </span>
                               </c:if>
                        </div>
                    </c:if>
                    
                    <div class="formInfoControl">
                        <a class="btn noLanguageOption" type="submit"><%=sLanguageBean.comPurchase() %></a>
                        <a class="btn noLanguageOption" type="submit_backward"><%=sLanguageBean.comBack() %></a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%>/orderTicket/cancel"><%=sLanguageBean.comCancel() %></a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>

