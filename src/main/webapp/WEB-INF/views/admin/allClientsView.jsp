<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 05.06.2022
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Clients</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.email}</td>
            <td>${client.phoneNumber}</td>
        </tr>
    </c:forEach>
    </tbody>
</table><br>
<a href="http://localhost:8080/homepage">Back to Home Page</a>
</body>
</html>
