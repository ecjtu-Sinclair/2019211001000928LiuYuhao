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
    <title>HW2</title>
</head>
<body>
<form method="post">
    <table border="3px" bgcolor="#fffaf0">
        <tr>
            New User Registration
        </tr>

        <tr>
            <td><input type="text" name="Name" placeholder="Username"/></td>
        </tr>

        <tr>
            <td><input type="password" name="Pwd" placeholder="Password"/></td>
        </tr>

        <tr>
            <td><input type="text" name="Email" placeholder="Email"/></td>
        </tr>

        <tr>
            <td>
                Gender
                <input type="radio" name="Gender" value="Male" checked="checked"/>Male
                <input type="radio" name="Gender" value="Female" /> Female
            </td>
        </tr>

        <tr>
            <td>
                <input type="date" name="Date" placeholder="Date of Birth"/>
            </td>>

        </tr>

        <tr>
            <td><input type="submit" value="register"/></td>
        </tr>

    </table></form>
</body>
</html>
