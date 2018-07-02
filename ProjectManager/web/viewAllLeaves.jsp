<%-- 
    Document   : viewAllLeaves
    Created on : Jul 1, 2018, 10:52:35 AM
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
        <h1>View all leaves</h1>
        <h1 style="color: red">Welcome, ${sessionScope.EMPINFO.name}</h1>
        <c:set var="listLeaves" value="${sessionScope.LISTLEAVES}"/>
        <c:if test="${not empty listLeaves}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Leave ID</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Accept</th>
                        <th>Request reason</th>
                        <th>Reject reason</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${listLeaves}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.leaveID}</td>
                            <td>${dto.fromDate}</td>
                            <td>${dto.toDate}</td>
                            <td>${dto.accept}</td>
                            <td>${dto.requestReason}</td>
                            <td>${dto.rejectReason}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty listLeaves}">
            <h1 style="color: blue">You don't have any leaves</h1>
        </c:if>
        <a href="requestLeave.jsp">Click here to come back to Request Leave Page</a>
    </body>
</html>
