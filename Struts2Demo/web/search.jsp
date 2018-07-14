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
            <s:property value="#session.USERNAME"/>
        </p> 

        <s:form action="searchLastName" method="GET">
            <s:textfield name="searchValue" label="Search Value" />
            <s:submit label="Search"/>
        </s:form>

        <s:if test="searchValue != null and searchValue != ''">
            <s:if test="listAccounts != null">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listAccounts" status="counter" var="dto"> 
                            <s:form action="updateAccount" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="#counter.count" />
                                    </td>
                                    <td>
                                        <s:property value="username"/>
                                        <s:hidden name="username" value="%{username}" />
                                    </td>
                                    <td>
                                        <s:textfield name="password" value="%{password}" />
                                    </td>
                                    <td>
                                        <s:property value="lastname"/>

                                    </td>
                                    <td>
                                        <s:checkbox name="checkAdmin" value="%{role}"/>
                                    </td>
                                    <s:url id="delLink" action="delete">
                                        <s:param name="pk" value="username"/>
                                        <s:param name="lastSearchValue" value="searchValue"/>
                                    </s:url>
                                    <td>
                                        <s:a href="%{delLink}">Delete</s:a>
                                        </td>
                                        <td>
                                        <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                        <s:submit value="Update"/>
                                    </td>

                                </tr>
                            </s:form>
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
