<%--
  Created by IntelliJ IDEA.
  User: aga
  Date: 28.05.2022
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" method='POST'>
    <table>
        <tr>
            <td>Login:</td>
            <td><input type='text' name='login' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Sign In" /></td>
        </tr>
    </table>
</form> <br>
<a href="http://localhost:8080/client/create">Register</a>
</body>
</html>
