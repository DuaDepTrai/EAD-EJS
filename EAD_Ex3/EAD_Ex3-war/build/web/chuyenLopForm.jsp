<%-- 
    Document   : chuyenLopForm
    Created on : Jan 10, 2026, 10:28:43 PM
    Author     : DUADEPTRAI
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chuyen Lop</title>
</head>
<body>
    <h1>Chuyen Lop cho SinhVien: <c:out value="${sv.name}"/></h1>
    <form action="students/chuyenLop" method="post">
        <input type="hidden" name="idSV" value="${sv.id}">
        Lop Moi: <select name="idLop">
            <c:forEach var="lop" items="${listLops}">
                <option value="${lop.id}" <c:if test="${lop.id == sv.lop.id}">selected</c:if>><c:out value="${lop.name}"/></option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Chuyen">
    </form>
</body>
</html>