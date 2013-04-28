<%-- 
    Document   : account
    Created on : Apr 11, 2013, 5:25:58 PM
    Author     : 52593578
--%>

<jsp:useBean id="rUser" type="beans.RUser" scope="request"></jsp:useBean>
<%--<jsp:useBean id="sLanguageBean" type="beans.accessInterface.LanguageBean" scope="session"></jsp:usebean>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/WEB-INF/jspf/common/headSession.jspf" %>
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/account.css" />
        
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
                </div>
            </div>
            
            <div id="content" class="defaultWidth">
                <c:if test="${errorMsg != null}">
                    <span class="error">
                        ${errorMsg["pageError"]}
                    </span>
                </c:if>   
                    
                <form action="<%=request.getContextPath()%>/signUp" method="POST" class="formInfoContainer">
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbUsername()%>: 
                        </label>
                            <input type="text" name="loginId" class="infoInput" value="${rUser.loginID}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["loginId"]}
                            </span>
                        </c:if>
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbPassword()%>: 
                        </label>
                        <input type="password" name="password" class="infoInput" value="" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["password"]}
                            </span>
                        </c:if>
                    </div>
                            
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbPasswordRe()%>: 
                        </label>
                        <input type="password" name="passwordr" class="infoInput" value="" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["passwordr"]}
                            </span>
                        </c:if>
                    </div>
                    
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbName()%>: 
                        </label>
                        <input type="text" name="name" class="infoInput" value="${rUser.userName}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["name"]}
                            </span>
                        </c:if> 
                    </div>
                        
                            
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbTel()%>: 
                        </label>
                        <input type="text" name="phone" class="infoInput" value="${rUser.userPhone}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["phone"]}
                            </span>
                        </c:if>    
                    </div>
                    
                    <div class="formInfoControl">
                        <label class="label">
                            <%=sLanguageBean.cAccountLbEmail()%>: 
                        </label>
                        <input type="text" name="email" class="infoInput" value="${rUser.userEmail}" />
                        <c:if test="${errorMsg != null}">
                            <span class="error">
                                ${errorMsg["email"]}
                            </span>
                        </c:if>
                    </div>
                            
                    <div class="formInfoControl">
                        <a type="submit" class="btn noLanguageOption"><%=sLanguageBean.comSignUp() %></a>
                        <a class="btn noLanguageOption" href="<%=request.getContextPath()%>"><%=sLanguageBean.comCancel() %></a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="asgClaim_stayButtom scrollLeft">
            <%@include file="/WEB-INF/jspf/common/asgClaim.jspf" %>
        </div>
    </body>
</html>
