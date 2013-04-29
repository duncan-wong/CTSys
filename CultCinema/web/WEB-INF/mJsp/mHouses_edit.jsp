<%-- 
    Document   : movies_create
    Created on : Apr 27, 2013, 7:26:26 PM
    Author     : A
--%>

<jsp:useBean id="rHouse" type="beans.RHouse" scope="request"></jsp:useBean>
<%--<jsp:useBean id="sLanguageBean" type="beans.accessInterface.LanguageBean" scope="session"></jsp:usebean>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/movies.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/movies.css" />
    <!-- jQuery -->
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.mousewheel.js"></script>
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
                        <%=sLanguageBean.hHousesMainTitle()%>
                    </h1>
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <c:if test="${errorMsg != null}">
                    <span class="error">
                        ${errorMsg["pageError"]}
                    </span>
                </c:if>   
                    
                <form action="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Houses_edit)%>" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cHousesLbName()%>: 
                        </label>
                            <input type="text" name="houseName" class="infoInput span4" value="${rHouse.houseName}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["houseName"]}
                            </span>
                        </c:if>
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cHousesLbTotalRow()%>: 
                        </label>
                        <span class="content">
                            ${rHouse.totalRow}
                        </span>
                    </div>
                            
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cHousesLbCapacity()%>: 
                        </label>
                        <span class="content">
                            ${rHouse.houseCapacity}
                        </span>
                    </div>
                        
                    <div class="formInfoControl">
                        <a type="submit" class="btn noLanguageOption"><%=sLanguageBean.comSave()%></a>
                        <a class="btn noLanguageOption" href="<%=common.URLConfig.getFullPath(common.URLConfig.SURLm_Houses)%>"><%=sLanguageBean.comCancel()%></a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>