<%-- 
    Document   : search
    Created on : Jun 5, 2018, 8:42:01 AM
    Author     : nguyenducthanh
--%>

<%@page import="sample.tblUser.tblUserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search page</h1>
        <font color="red">
        Welcome, ${sessionScope.USERNAME} 
        </font>

        <form action="DieuphoiServlet" method="post">
            Search value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="SearchPage" name="btnAction" />
        </form><br>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
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
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="DieuphoiServlet" method="post">
                            <tr>
                                <td>
                                    ${counter.count}

                                </td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>
                                    ${dto.lastname}
                                </td>
                                <td>
                                    <input type="checkbox" name="cbRole" value="ON" 
                                           <c:if test="${dto.role}">
                                               checked="checked"
                                           </c:if>

                                           />
                                </td>
                                <td>
                                    <c:url var="delLink" value="DieuphoiServlet">
                                        <c:param name="btnAction" value="deleteRecord"/>
                                        <c:param name="txtUsername" value="${dto.username}"/>
                                        <c:param name="txtSearchValue" value="${searchValue}"/>
                                    </c:url>
                                    <a href="${delLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="txtLastSearch" value="${searchValue}" />
                                    <input type="submit" value="UpdateRecord" name="btnAction" />
                                </td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </table>


        </c:if>
        <c:if test="${empty result}">
            <h2>No record is match</h2>

        </c:if>
    </c:if>



    <%--  <%
        HttpSession mySession = request.getSession();
        String username = (String) mySession.getAttribute("username");
        if (username != null) {
    %>
    <h1 style="color: red">Hello <%= username%></h1>
    <%
        }
        Cookie[] cookies = request.getCookies();
        String userNameCookie = "";
        if (cookies != null) {
            for (Cookie myCookie : cookies) {
                if (!myCookie.getName().equals("JSESSIONID")) {
                    userNameCookie = myCookie.getName();
                }
            }
            out.println("Welcome "+userNameCookie);
        }
    %>

        <form action="DieuphoiServlet" method="post">
            Search value <input type="text" name="txtSearchValue" value="" />
            <input type="submit" value="SearchPage" name="btnAction" />
        </form>

        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<tblUserDTO> result = (List<tblUserDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Lastname</th>
                    <th>isAdmin</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (tblUserDTO row : result) {
                        String deleteUrl = "DieuphoiServlet?btnAction=deleteRecord"
                                + "&txtSearchValue=" + searchValue
                                + "&txtUsername=" + row.getUsername();
                %>
            <form action="DieuphoiServlet" method="POST">
                <tr>
                    <td><%= ++count%>
                    </td> 
                    <td>
                        <%=row.getUsername()%>
                        <input type="hidden" name="txtUsername" value="<%=row.getUsername()%>" />
                    </td>
                    <td> 
                        <input type="text" name="txtPassword" value="<%=row.getPassword()%>" />                        
                    </td>
                    <td>
                        <%=row.getLastname()%>
                    </td>
                    <td>
                        <input type="checkbox" name="cbRole" 
                               <%
                                   if (row.isRole()) {
                               %> 
                               checked="checked"
                               <%
                                   }
                               %>
                               />
                    </td>
                    <td><a href="<%=deleteUrl%>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="txtLastSearch" value="<%= searchValue%>" />
                        <input type="submit" value="UpdateRecord" name="btnAction" />
                    </td>

                </tr>
            </form>
            <%                    }

            %>
        </tbody>
    </table>


    <%            } else {
    %>
    <h2>No record found</h2>
    <%
            }
        } // end if
%>
    --%>
</body>
</html>
