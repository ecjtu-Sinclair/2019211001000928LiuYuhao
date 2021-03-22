<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/3/15
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<html>
<head>
    <title>New User Registration</title>
</head>
<body>
<form method="post" action="/register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="male">Male <input type="radio" name="female">Female <br/>
    Date of Birth:<input type="text name=" name="birthDate"><br/>
    <input type="submit" name="Register"/>
</form>
</body>
</html>
