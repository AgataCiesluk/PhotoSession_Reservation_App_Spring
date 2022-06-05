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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <th>Place</th>
            <th>Photo Session type</th>
            <th>Number of photos</th>
            <sec:authorize access="hasAuthority('ADMIN')">
                <th>Client First Name</th>
                <th>Client Last Name</th>
                <th>Client Comment</th>
                <th>Completed</th>
                <th>Action</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="photoSess" items="${allSessions}">
            <tr>
                <td>${photoSess.id}</td>
                <td>${photoSess.date}</td>
                <td>${photoSess.area}</td>
                <td>${photoSess.place}</td>
                <td>${photoSess.photoType.name}</td>
                <td>${photoSess.photoType.numberOfPhotos}</td>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <td>${photoSess.client.firstName}</td>
                    <td>${photoSess.client.lastName}</td>
                    <td>${photoSess.clientComment}</td>
                    <td>${photoSess.completed}</td>
                    <c:if test="${photoSess.completed == false}">
                        <td><a href="http://localhost:8080/admin/sess-complete?id=${photoSess.id}">Complete</a></td>
                    </c:if>
                    <c:if test="${photoSess.completed == true}">
                        <td>Done</td>
                    </c:if>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if><br>
<a href="http://localhost:8080/homepage">Back to Home Page</a>
</body>
</html>
