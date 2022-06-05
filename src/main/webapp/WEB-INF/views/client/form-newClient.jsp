<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 28.05.2022
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Client registration</title>
</head>
<body>
REGISTRATION FORM:<br>

<form:form method="POST" modelAttribute="client">
    First name: <form:input path="firstName"/><br>
    <form:errors path="firstName" cssClass="ui-state-error-text"/><br>
    Last name: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="ui-state-error-text"/><br>
    Email: <form:input path="email"/><br>
    <form:errors path="email" cssClass="ui-state-error-text"/><br>
    Phone number: <form:input type="number" path="phoneNumber"/><br>
    <form:errors path="phoneNumber" cssClass="ui-state-error-text"/><br>
    Username: <form:input path="username"/><br>
    <form:errors path="username" cssClass="ui-state-error-text"/><br>
    Password: <form:password path="userPassword"/><br>
    <form:errors path="userPassword" cssClass="ui-state-error-text"/><br>
    <button type="submit">Create Account</button>
</form:form>
</body>
</html>
