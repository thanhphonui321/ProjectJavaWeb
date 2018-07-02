<%-- 
    Document   : search
    Created on : Jun 28, 2018, 7:51:21 AM
    Author     : nguyenducthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search page</h1><br>
        <p style="color: red">Welcome, 
            <s:property value="username"/>
            <s:property value="%{#session.USERNAME}"/>
        </p> 

        <s:form action="searchLastName" method="GET">
            <s:textfield name="searchValue" label="Search Value" />
            <s:submit label="Search"/>
        </s:form>

        <s:if test="%{!searchValue.isEmpty()}">
            <s:if test="%{listAccounts != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listAccounts" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}" />
                                </td>
                                <td>
                                    <s:property value="username"/>
                                </td>
                                <td>
                                    <s:property value="password"/>
                                </td>
                                <td>
                                    <s:property value="lastname"/>

                                </td>
                                <td>
                                    <s:property value="role"/>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                <h2>No record match!!!</h2>
            </s:else>
        </s:if>
    </body>
</html>
