<%@ page import="com.LiuYuhao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/4/27
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action = "UpdateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    Username:<input type="text"  name="username" value="<%=u.getUsername()%>" placeholder="Username" maxlength="8"/><br/>
    Password:<input type="password"  name="password" value="<%=u.getPassword()%>" placeholder="Password" minlength="8" maxlength="12" /><br/>
    Email:<input type="Email"  name="email" value="<%=u.getEmail()%>" pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$" placeholder="Email"/><br/>
    <p>Gander :</p><input type="radio" name="gender" value="male" <%="male".equals(u.getGender())? "checked":""%>/> male<input type="radio" name="gender" value="female" <%="female".equals(u.getGender())? "checked":""%>/>female
    <br/>
    Birthdate:<input type="date"  name="birthdate" value="<%=u.getBirthdate()%>" placeholder="Birthdate(yyy-mm-dd)"/><br/>
    <input type="submit" value="Save Changes"/>
</form>
<%@include file="footer.jsp"%>
