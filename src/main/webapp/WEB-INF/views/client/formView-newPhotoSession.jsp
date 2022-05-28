<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 28.05.2022
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Reserve New Photo Session</title>
</head>
<body>
ADD NEW PHOTO SESSION FORM:<br>

<form:form action="/client/session-add" method="POST" modelAttribute="photoSession">
    Type: <form:select path="type">
    <form:option value="wedding" label="Wedding Reportage"/>
    <form:option value="occasional" label="Occasional Reportage"/>
    <form:option value="lifestyle" label="Lifestyle Session"/>
    <form:option value="outdoor" label="Outdoor session"/>
    <form:option value="newborn" label="Newborn session"/>
    <form:option value="pregnancy" label="Pregnancy session"/>
    <form:option value="business" label="Business session"/>
    <form:option value="other" label="Other - describe in comment"/>
    </form:select><br>
    <form:errors path="type" cssClass="ui-state-error-text"/><br>
    Date yyyy-MM-dd: <form:input path="date"/><br>
    <form:errors path="date" cssClass="ui-state-error-text"/><br>
    Time HH:mm: <form:input path="time"/><br>
    <form:errors path="time" cssClass="ui-state-error-text"/><br>
    Area: <form:input path="area"/><br>
    <form:errors path="area" cssClass="ui-state-error-text"/><br>
    Place: <form:input path="place"/><br>
    <form:errors path="place" cssClass="ui-state-error-text"/><br>
    Comment: <form:textarea path="clientComment" rows="5" cols="30"/><br>
    <form:errors path="clientComment" cssClass="ui-state-error-text"/><br>
    <button type="submit">Reserve Session</button>
</form:form>
</body>
</html>
