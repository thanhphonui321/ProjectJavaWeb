<%-- 
    Document   : manageLeave
    Created on : Jun 28, 2018, 3:55:03 PM
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
        <form action="logout" method="POST">
            <input type="submit" value="Log out" name="btnLogout" />
        </form><br><br>
        <p style="font-weight: bold; display: inline; font-size: 1.5em">Department Name: </p> ${sessionScope.EMPINFO.depName}<br><br>
        <p style="font-weight: bold; display: inline; font-size: 1.5em">Total of employee:</p> ${sessionScope.TOTALACCOUNT}<br><br>
        <form action="searchLeave" method="POST">
            (Date in format: dd-MM-yyyy)<br><br>
            From <input type="text" name="txtFrom" value="${param.txtFrom}" />&nbsp;&nbsp;&nbsp;&nbsp;
            To <input type="text" name="txtTo" value="${param.txtTo}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Search" />
        </form>
        <c:set var="listSearch" value="${sessionScope.SEARCHLIST}"/>
        <c:set var="firstTime" value="${requestScope.FIRSTTIMESEARCH}"/>
        <c:if test="${not empty listSearch}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Employee ID</th>
                        <th>Name</th>
                        <th>Salary</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Accept</th>
                        <th>Request reason</th>
                        <th>Reject reason</th>
                        <th>Update</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${listSearch}" varStatus="counter">
                    <form action="confirm" method="POST">
                        <tr>
                        <input type="hidden" name="txtFrom" value="${param.txtFrom}" />
                        <input type="hidden" name="txtTo" value="${param.txtTo}" />
                        <input type="hidden" name="txtLeaveID" value="${dto.leaveID}" />
                        <td>${counter.count}</td>
                        <td>${dto.empID}</td>
                        <td>${dto.name}</td>
                        <td>${dto.salary}</td>
                        <td>${dto.address}</td>
                        <td>${dto.email}</td>
                        <td>${dto.phone}</td>
                        <td>${dto.accept}</td>
                        <td>${dto.requestReason}</td>
                        <td> <input type="text" name="txtRejectReason" value="${dto.rejectReason}" /> </td>
                        <td> <input type="submit" value="Accept" name="btnConfirm"/><br>
                            <input type="submit" value="Reject" name="btnConfirm" />
                        </td>
                        <td> <a href="change?empID=${dto.empID}&depName=${dto.depName}">Change</a> </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${not empty requestScope.FAULT}">
        <h1 style="color: red">${requestScope.FAULT}</h1>
    </c:if>
    <c:if test="${firstTime ne 1 and empty listSearch and empty requestScope.FAULT}">
        <h1 style="color: blue">There is no leaves</h1>
    </c:if>


</body>
</html>
