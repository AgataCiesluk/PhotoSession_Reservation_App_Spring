<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 29.05.2022
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Photo Sessions</title>
</head>
<body>
<c:if test="${empty allSessions}">
    There is no photo sessions to show.
</c:if>
<c:if test="${not empty allSessions}">
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Area</th>
        <th>Client First Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="photoSess" items="${allSessions}">
        <tr>
            <td>${photoSess.id}</td>
            <td>${photoSess.date}</td>
            <td>${photoSess.area}</td>
            <td>${photoSess.client.firstName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
</body>
</html>
