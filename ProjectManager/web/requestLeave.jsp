<%-- 
    Document   : requestLeave
    Created on : Jun 30, 2018, 3:43:20 PM
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
        </form>
        <h1>Request Leave</h1>
        <c:set var="empInfo" value="${sessionScope.EMPINFO}"/>
        Employee ID: ${empInfo.employeeID}<br>
        Name: ${empInfo.name}<br>
        Department: ${empInfo.depName}<br>
        Salary: ${empInfo.salary}<br>
        Leave Date <br>
        <form action="requestLeave" method="POST" id="requestLeaveForm">       
            (Date in format : dd-MM-yyyy)<br>
            From <input type="text" name="txtFrom" value="${param.txtFrom}" /> 
            To <input type="text" name="txtTo" value="${param.txtTo}" /><br><br>
            Reason  <textarea rows="4" cols="50" name="txtReason" form="requestLeaveForm">${param.txtReason}</textarea> <br><br>
            <input type="submit" value="Request" /> 
        </form>
        <c:if test="${not empty requestScope.FAULT}">
            <p style="color: red">
                ${requestScope.FAULT}
            </p>
        </c:if>
        <a href="viewAllLeaves">View all Leaves</a>


    </body>
</html>
