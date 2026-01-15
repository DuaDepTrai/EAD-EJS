<%-- 
    Document   : editForm
    Created on : Jan 10, 2026, 10:28:26 PM
    Author     : DUADEPTRAI
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update SinhVien</title>
</head>
<body>
    <h1>Update SinhVien</h1>
    <form action="students/edit" method="post">
        <input type="hidden" name="id" value="${sv.id}">
        Name: <input type="text" name="name" value="${sv.name}"><br>
        Lop: <select name="idLop">
            <c:forEach var="lop" items="${listLops}">
                <option value="${lop.id}" <c:if test="${lop.id == sv.lop.id}">selected</c:if>><c:out value="${lop.name}"/></option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>