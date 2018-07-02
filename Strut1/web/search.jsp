<%-- 
    Document   : search
    Created on : Jun 26, 2018, 9:19:48 AM
    Author     : nguyenducthanh
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
        Welcome, ${sessionScope.LoginStrutsActionForm.username}
        <h1>Search page</h1>
        <form action="searchLastName.do">
            <input type="text" name="searchValue" value="${param.searchValue}" />
            <input type="submit" value="search" />
        </form><br>

        <c:set var="searchValue" value="${param.searchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SearchLastNameStrutsActionForm.listAccounts}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Role</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.username}</td>
                                <td>${dto.password}</td>
                                <td>${dto.lastname}</td>
                                <td>${dto.isRole()}</td>
                                <c:url var="dellink" value="delete.do">
                                    <c:param name="pk" value="${dto.username}"/>
                                    <c:param name="searchValue" value="${searchValue}"/>
                                </c:url>
                                <td>
                                    <a href="${dellink}">Delete</a>
                                </td>
                            </tr>
                    </c:forEach>

                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h1>No record match</h1>
        </c:if>

    </c:if>
</body>
</html>
