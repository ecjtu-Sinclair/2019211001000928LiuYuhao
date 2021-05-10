<%@ page import="com.LiuYuhao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/4/12
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie[] allCookies=request.getCookies();
    for(Cookie c:allCookies){
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>

<%
    User u=(User) session.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td></td><%=u.getUsername()%></>td>
    </tr>
    <tr>
        <td>Password:</td><td></td><%=u.getPassword()%></>td>
    </tr>
    <tr>
        <td>Email:</td><td></td><%=u.getEmail()%></>td>
    </tr>
    <tr>
        <td>Gender:</td><td></td><%=u.getGender()%></>td>
    </tr>
    <tr>
        <td>Birth Date:</td><td></td><%=u.getBirthdate()%></>td>
    </tr>
</table>
<%@include file="footer.jsp"%>