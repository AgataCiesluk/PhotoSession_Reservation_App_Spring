<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 28.05.2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<sec:authorize access="hasAuthority('CLIENT')">
<p>Hi ${loggedUser.client.firstName}!</p>
<a href="http://localhost:8080/client/session-add?username=${loggedUser.username}">Reserve Photo Session</a><br>
</sec:authorize>
<sec:authorize access="hasAuthority('ADMIN')">
<p>Hi ${loggedUser.username}!</p>
</sec:authorize>
Show:
<ul>
    <li><a href="http://localhost:8080/photo-sess/future">Future Photo Sessions</a></li>
    <li><a href="http://localhost:8080/photo-sess/completed">Completed Photo Sessions</a></li>
    <li><a href="http://localhost:8080/photo-sess/all">All Photo Sessions</a></li>
</ul><br>
<a href="http://localhost:8080/logout">Logout</a>
</body>
</html>
