<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/3/10
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>HW1</title>
</head>

<body>
<%
    java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    java.util.Date currentTime = new java.util.Date();
    String time = simpleDateFormat.format(currentTime).toString();
    out.println("Name:Liu Yuhao<br>");
    out.println("ID:2019211001000928<br>");
    out.println("Data and Time："+time);
%>

</body>
</html>
