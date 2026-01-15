<%-- 
    Document   : delete
    Created on : Jan 10, 2026, 10:28:58 PM
    Author     : DUADEPTRAI
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete SinhVien</title>
</head>
<body>
    <h1>Delete SinhVien: <c:out value="${sv.name}"/></h1>
    <a href="students/delete?id=${sv.id}">Confirm Delete</a>
    <a href="students">Cancel</a>
</body>
</html>