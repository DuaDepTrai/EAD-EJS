<%-- 
    Document   : addForm
    Created on : Jan 10, 2026, 10:28:12 PM
    Author     : DUADEPTRAI
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add SinhVien</title>
</head>
<body>
    <h1>Add SinhVien</h1>
    <form action="students/add" method="post">
        Name: <input type="text" name="name"><br>
        Lop: <select name="idLop">
            <c:forEach var="lop" items="${listLops}">
                <option value="${lop.id}"><c:out value="${lop.name}"/></option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>