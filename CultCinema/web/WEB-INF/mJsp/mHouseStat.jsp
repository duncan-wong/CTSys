<%-- 
    Document   : mHouseStat
    Created on : Apr 29, 2013, 6:45:42 PM
    Author     : A
--%>

<jsp:useBean id="rHouse" type="beans.RHouse" scope="request"></jsp:useBean>
<jsp:useBean id="rShowCol" type="beans.RMovieShowCol" scope="request"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movie.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/movieShow.css" />
        
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
                        <%=sLanguageBean.hHousesStatMainTitle()%>
                    </h1>
                    <div class="headerControl">
                        <a href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Houses)%>" class="btn">
                            <%=sLanguageBean.comBack()%>
                        </a>
                    </div>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <div id="movie${rHouse.houseName}" class="movieContainer">

                    <div class="movieDescription">
                        <div class="movieDescriptionItem">
                            <span class="movieTitle">
                                ${rHouse.houseName}
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cHousesLbCapacity()%>: 
                            </span>
                            <span class="content">
                                ${rHouse.houseCapacity}
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cHousesLbDisabledSeat()%>: 
                            </span>
                            <span class="content">
                                ${disabledCount}
                            </span>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.comSale()%>: 
                            </span>
                            <p class="content">
                                <%=sLanguageBean.comHKD()%> ${rHouse.sales}
                            </p>
                        </div>
                        <div class="movieDescriptionItem">
                            <span class="label">
                                <%=sLanguageBean.cHousesLbTotalRow()%>: 
                            </span>
                            <p class="content">
                                <%=rShowCol.count()%>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="formInfoContainer">
                    <div class="formInfoControl">
                        <c:forEach items="${rShowCol.all}" var="movieShow">
                            <%@include file="/WEB-INF/jspf/manager/mHouseMovieShow.jspf" %>
                        </c:forEach>
                    </div>
                </div>
                    
            </div>
                    
                    
                    
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
