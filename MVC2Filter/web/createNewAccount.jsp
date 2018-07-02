<%-- 
    Document   : createNewAccount
    Created on : Jun 13, 2018, 4:11:38 PM
    Author     : nguyenducthanh
--%>

<%@page import="sample.tblUser.tblUserInsertErr"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        <h1>CREATE NEW ACCOUNT</h1>
                <form action="DieuphoiServlet" method="post">
                    User name* <input type="text" name="txtUsername" value="" /> (6-20 chars)
                    Password* <input type="password" name="txtPassword" value="" /> (6-30 chars)
                    Confirm* <input type="password" name="txtConfirm" value="" />
                    Full name* <input type="text" name="txtFullName" value="" />( 2-50 chars)
                </form>-->

        <h1>Create new Account</h1>

        <form action="createNewAccount" method="post">
            User name* <input type="text" name="txtUsername" value="${param.txtUsername}" /> (6-20 chars)<br>
            <c:set var="errors" value="${requestScope.ERROR}"/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">
                ${errors.usernameLengthErr}
                </font><br>
            </c:if>

            Password* <input type="password" name="txtPassword" value="" /> (6-30 chars)<br>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                ${errors.passwordLengthErr}
                </font><br>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="" /><br>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                ${errors.confirmNotMatch}
                </font><br>
            </c:if>
            Full name* <input type="text" name="txtFullName" value="${param.txtFullName}" />( 2-50 chars)<br>
            <c:if test="${not empty errors.fullnameLengthErr}">
                <font color="red">
                ${errors.fullnameLengthErr}
                </font><br>
            </c:if>
            <input type="submit" value="Register" name="btnAction" /><br>
            <input type="reset" value="Reset" />
        </form>
        <c:if test="${not empty errors.userIsExisted}">
            <font color="red">
            ${errors.userIsExisted}
            </font><br>
        </c:if>




        <%--  <%
            tblUserInsertErr errors = (tblUserInsertErr) request.getAttribute("ERROR");

        %>
        <form action="DieuphoiServlet" method="POST">
            User name* <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername")%>" /><br>
            <%
                if (errors != null) {
                    if (errors.getUsernameLengthErr()!= null) {
            %>
            <font color ="red"> 
            <%= errors.getUsernameLengthErr()%>
            </font>
            <br>

            <%
                    }
                }
            %>
            Password <input type="text" name="txtPassword" value="" /><br>
            <%
                if (errors != null) {
                    if (errors.getPasswordLengthErr()!= null) {
            %>
            <font color ="red"> 
            <%= errors.getPasswordLengthErr()%>
            </font>
            <br>

            <%
                    }
                }
            %>
            Confirm <input type="text" name="txtConfirm" value="" /><br>
            <%
                if (errors != null) {
                    if (errors.getConfirmNotMatch()!= null) {
            %>
            <font color ="red"> 
            <%= errors.getConfirmNotMatch()%>
            </font>
            <br>

            <%
                    }
                }
            %>
            Fullname <input type="text" name="txtFullName" value="<%= request.getParameter("txtFullName")%>" /><br>
            <%
                if (errors != null) {
                    if (errors.getFullnameLengthErr()!= null) {
            %>
            <font color ="red"> 
            <%= errors.getFullnameLengthErr()%>
            </font>
            <br>

            <%
                    }
                }
            %>
            <input type="submit" name="btnAction" value="Register" /> <br>
            <input type="reset" name="reset" value="Reset" /><br>
        </form>
        <%
            if (errors != null) {
                if (errors.getUserIsExisted()!= null) {
        %>
        <font color ="red"> 
        <%= errors.getUserIsExisted()%>
        </font
        <br>
        <%
                }
            }
        %>
        --%>
    </body>
</html>
