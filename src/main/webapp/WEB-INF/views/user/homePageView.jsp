<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 28.05.2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Home Page</title>
</head>
<body>
<%--Ponizsze dwie linijki beda tylko dla uzytkownika o roli CLIENT--%>
<p>Hi ${loggedUser.client.firstName}!</p>
<a href="http://localhost:8080/client/session-add?userLogin=${loggedUser.login}">Reserve Photo Session</a><br>

Show:
<ul>
    <li><a href="http://localhost:8080/photo-sess/future">Future Photo Sessions</a></li>
    <li>Completed Photo Sessions</li>
    <li>All Photo Sessions</li>
</ul>
</body>
</html>
