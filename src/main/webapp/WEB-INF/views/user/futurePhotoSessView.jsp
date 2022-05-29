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
<html>
<head>
    <title>Future Photo Sessions View</title>
</head>
<body>
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
    <c:forEach var="futureSess" items="${futureSessions}">
        <tr>
            <td>${futureSess.id}</td>
            <td>${futureSess.date}</td>
            <td>${futureSess.area}</td>
            <td>${futureSess.client.firstName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
