<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/4/6
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<body>
<h1 Style="font-size:20px">Login</h1>
    <%
    if (!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
 %>
<%
    Cookie[] allCookie=request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookie!=null){
        for (Cookie c:allCookie){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassoword")){
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMeVale=c.getValue();
            }
        }
    }
%>
<form method="post" action="Login">
    Username:<input type="text" name="username" value="<%=username%>"><br>
    Password:<input type="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1") ?checked:""%>checked/>RememberMe<br/>

    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>