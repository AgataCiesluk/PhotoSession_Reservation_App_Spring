<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 29.05.2022
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Future Photo Sessions</title>
</head>
<body>
<c:if test="${empty futureSessions}">
    There is no future photo sessions to show.
</c:if>
<c:if test="${not empty futureSessions}">
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Area</th>
        <sec:authorize access="hasAuthority('ADMIN')">
        <th>Client First Name</th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="futureSess" items="${futureSessions}">
        <tr>
            <td>${futureSess.id}</td>
            <td>${futureSess.date}</td>
            <td>${futureSess.area}</td>
            <sec:authorize access="hasAuthority('ADMIN')">
            <td>${futureSess.client.firstName}</td>
            </sec:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if><br>
<a href="http://localhost:8080/homepage">Back to Home Page</a>
</body>
</html>
