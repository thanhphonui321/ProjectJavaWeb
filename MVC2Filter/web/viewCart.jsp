<%-- 
    Document   : viewCart
    Created on : Jun 10, 2018, 3:01:07 PM
    Author     : nguyenducthanh
--%>

<%@page import="java.util.Map"%>
<%@page import="sample.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View card</title>
    </head>
    <body>
        <%--  <%
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    if (cart.getItems() != null) {
%> 
        
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action="RemoveItemServlet" method="post">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 0;
                    for (Map.Entry<String, Integer> item : items.entrySet()) {
                %>
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td><%= item.getKey()%></td>
                    <td><%= item.getValue()%></td>
                    <td> <input type="checkbox" name="cbRemoveItem" value="<%= item.getKey()%>" /> </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="3"> <a href="shoppingCartOnline.html">Come back to store</a> </td>
                    <td> <input type="submit" value="Remove Item" name="btnAction" /> </td>
                </tr>
            </form>
        </tbody>
    </table>

    <%
            return;
        }
    } 

    %>--%>

        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart.items}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <form action="removeItem" method="POST">
                    <c:forEach var="item" items="${cart.items.entrySet()}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${item.getKey()}</td>
                            <td>${item.getValue()}</td>
                            <td> <input type="checkbox" name="cbRemoveItem" value="${item.getKey()}" /> </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="3"><a href="shoppingCartOnline.html">Come back to store</a></td>
                        <td> <input type="submit" value="Remove Item" name="btnAction" /> </td>    
                    </tr>
                </form>
            </tbody>
        </table>

    </c:if>
    <c:if test="${empty cart.items}">
        <h1>No products found</h1>
        <a href="shoppingCartOnline.html">Come back to store</a>
    </c:if>

</body>
</html>
