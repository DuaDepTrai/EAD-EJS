<%-- 
    Document   : index
    Created on : Jan 10, 2026, 10:27:47 PM
    Author     : DUADEPTRAI
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List SinhVien</title>
</head>
<body>
    <h1>List SinhVien</h1>
    <a href="students/add">Add SinhVien</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Lop</th>
            <th>Diems</th>
            <th>Action</th>
        </tr>
        <c:forEach var="sv" items="${listSVs}">
            <tr>
                <td><c:out value="${sv.id}"/></td>
                <td><c:out value="${sv.name}"/></td>
                <td><c:out value="${sv.lop.name}"/></td>
                <td>
                    <ul>
                        <c:forEach var="d" items="${sv.diems}">
                            <li><c:out value="${d.mon.name} - ${d.mark} - ${d.examDate}"/></li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <a href="students/edit?id=${sv.id}">Update</a>
                    <a href="students/chuyenLop?id=${sv.id}">Chuyen Lop</a>
                    <a href="students/delete?id=${sv.id}" onclick="return confirm('Delete?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>