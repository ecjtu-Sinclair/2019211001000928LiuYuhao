<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/4/12
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>Username:</td><td></td><%=request.getAttribute("username")%></>td>
    </tr>
    <tr>
        <td>Password:</td><td></td><%=request.getAttribute("password")%></>td>
    </tr>
    <tr>
        <td>Email:</td><td></td><%=request.getAttribute("email")%></>td>
    </tr>
    <tr>
        <td>Gender:</td><td></td><%=request.getAttribute("gender")%></>td>
    </tr>
    <tr>
        <td>Birth Date:</td><td></td><%=request.getAttribute("birthdate")%></>td>
    </tr>
</table>
<%@include file="footer.jsp"%>