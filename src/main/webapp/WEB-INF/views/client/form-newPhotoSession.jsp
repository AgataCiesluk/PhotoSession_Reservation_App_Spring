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
    Type: <form:select itemValue="id" itemLabel="name" path="photoType.id" items="${types}"/><br>
    <form:errors path="photoType.id" cssClass="ui-state-error-text"/><br>
    Date yyyy-MM-dd: <form:input type="date" path="date"/><br>
    <form:errors path="date" cssClass="ui-state-error-text"/><br>
    Time HH:mm: <form:input type="time" path="time"/><br>
    <form:errors path="time" cssClass="ui-state-error-text"/><br>
    Area: <form:select path="area">
        <form:option value="-" label="--Please Select--"/>
        <form:option value="kashubia" label="Kashubia"/>
        <form:option value="tricity" label="Tricity"/>
        <form:option value="masuria" label="Masuria"/>
        <form:option value="other" label="Other-add as a comment"/>
    </form:select><br>
    <form:errors path="area" cssClass="ui-state-error-text"/><br>
    Place: <form:select path="place">
    <form:option value="-" label="--Please Select--"/>
    <form:option value="forest" label="Forest"/>
    <form:option value="meadow" label="Meadow"/>
    <form:option value="lake" label="Lake"/>
    <form:option value="beach" label="Beach"/>
    <form:option value="city" label="City"/>
    <form:option value="indoor" label="Indoor"/>
    <form:option value="other" label="Other-add as a comment"/>
    </form:select><br>
    <form:errors path="place" cssClass="ui-state-error-text"/><br>
    Comment: <form:textarea path="clientComment" rows="5" cols="30"/><br>
    <form:errors path="clientComment" cssClass="ui-state-error-text"/><br>
    <form:hidden path="client"/>
    <button type="submit">Reserve Session</button>
</form:form>
</body>
</html>
