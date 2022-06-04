<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 02.06.2022
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Completed Photo Sessions</title>
</head>
<body>
<c:if test="${empty completedSessions}">
    There is no completed photo sessions to show.
</c:if>
<c:if test="${not empty completedSessions}">
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
    <c:forEach var="completedSess" items="${completedSessions}">
        <tr>
            <td>${completedSess.id}</td>
            <td>${completedSess.date}</td>
            <td>${completedSess.area}</td>
            <td>${completedSess.client.firstName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if><br>
<a href="http://localhost:8080/homepage">Back to Home Page</a>
</body>
</html>
