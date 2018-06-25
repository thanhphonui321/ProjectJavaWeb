<%-- 
Document   : loginProcess
Created on : Jun 12, 2018, 10:02:15 AM
Author     : nguyenducthanhhjj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Process</h1>
        <jsp:useBean id="login" class="sample.beans.LoginBean" scope="session"/>

        <jsp:setProperty name="login" property="*" />

        <%--<jsp:setProperty name="login" property="username"/>--%>
        <%--<jsp:setProperty name="login" property="password"/>--%>

        <%--<jsp:setProperty name="login" property="username" param="txtUsername" />--%>
        <%--<jsp:setProperty name="login" property="password" param="txtPassword" />--%>

        <%--<jsp:setProperty name="login" property="username" value='<%= request.getParameter("txtUsername") %>' />--%>
        <%--<jsp:setProperty name="login" property="password" value='<%= request.getParameter("txtPassword") %>' />--%>
        <%--<jsp:getProperty name="login" property="username" />--%>

        <c:if test="${login.checkLogin()}">
            <jsp:forward page="search.jsp">
                <jsp:param name="par1" value="JSP"/>
                <jsp:param name="par2" value="Java"/>
            </jsp:forward>
        </c:if>


        <%--    <%
            if (login.checkLogin()) {
        %>
        <jsp:forward page="search.jsp">
            <jsp:param name="par1" value="JSP"/>
            <jsp:param name="par2" value="Java"/>
        </jsp:forward>
        <%
            }
        %>
        --%>
        <h2 style="color:red"> Invalid user name or password </h2>





    </body>
</html>
