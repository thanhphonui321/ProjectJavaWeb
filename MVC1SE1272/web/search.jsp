<%-- 
    Document   : search
    Created on : Jun 14, 2018, 7:28:14 AM
    Author     : nguyenducthanh
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="search.jsp" method="POST">
            <h1>Welcome:${param.username} (Request parameter)</h1>
            <h2 style="color:red">Welcome: 
                ${sessionScope.login.username}
                (Session)
            </h2>
            <h2 style="color:blue">Welcome: 
                ${login.username}
                (Attribute)
            </h2>
            <jsp:useBean id="login" scope="session" class="sample.beans.LoginBean"/>
            <h2 style="color: green"> Welcome, <jsp:getProperty name="login" property="username"/> (Standard action get property) </h2>
            Your search: <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="btnAction" />
        </form>
        </br>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <sql:setDataSource var="con" dataSource="Connect1272"/>
            <c:if test="${not empty con}">
                <c:catch var="ex">
                    <sql:query var="rs" dataSource="${con}">
                        Select username,password as 'Mật khẩu',lastname as 'Full name', isAdmin as 'Role' from tblUser where lastname like ?
                        <sql:param value="%${searchValue}%"/>
                    </sql:query>
                    <c:if test="${rs.rowCount gt 0}">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                        <c:forEach var="colName" items="${rs.columnNames}">
                                        <th>
                                            ${colName}
                                        </th>
                                    </c:forEach>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${rs.rowsByIndex}" varStatus="counter">
                                    <tr>
                                        <td>
                                            ${counter.count}
                                        </td>
                                        <c:forEach var="col" items="${row}">
                                            <td>${col}</td>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </c:if>
                    <c:if test="${rs.rowCount le 0}">
                        <h2>No record is matched!!!</h2>
                    </c:if>
                </c:catch>
                <c:if test="${not empty ex}">
                    <h2 style="color: red">
                        Errors occur:
                        ${ex}
                    </h2>
                </c:if>
            </c:if>
        </c:if>
    </body>
</html>
