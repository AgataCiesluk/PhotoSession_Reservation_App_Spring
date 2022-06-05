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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <th>Place</th>
            <th>Photo Session type</th>
            <th>Number of photos</th>
            <sec:authorize access="hasAuthority('ADMIN')">
                <th>Client First Name</th>
                <th>Client Last Name</th>
                <th>Client Comment</th>
                <th>Completed</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="completedSess" items="${completedSessions}">
            <tr>
                <td>${completedSess.id}</td>
                <td>${completedSess.date}</td>
                <td>${completedSess.area}</td>
                <td>${completedSess.place}</td>
                <td>${completedSess.photoType.name}</td>
                <td>${completedSess.photoType.numberOfPhotos}</td>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <td>${completedSess.client.firstName}</td>
                    <td>${completedSess.client.lastName}</td>
                    <td>${completedSess.clientComment}</td>
                    <td>${completedSess.completed}</td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if><br>
<a href="http://localhost:8080/homepage">Back to Home Page</a>
</body>
</html>
