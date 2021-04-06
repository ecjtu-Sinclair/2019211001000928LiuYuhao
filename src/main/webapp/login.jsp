<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/4/6
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>>
<form method="post" action="login">
    Username:<input type="text" name="name"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input type="login" value="Send data to server"/>
</form>
<%@include file="footer.jsp"%>