<%-- 
    Document   : index
    Created on : Jan 6, 2026, 12:22:20 AM
    Author     : DUADEPTRAI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="new.jsp">Add new</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${employees}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.fullName}</td>
                    <td>${e.phoneNo}</td>
                    <td>
                        <a href="Delete?id=${e.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
