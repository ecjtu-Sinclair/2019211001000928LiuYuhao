<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/4/11
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>

<h1>User List </h1>
<table border=1>
    <tr>
        <td>ID</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>BirthDate</td>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");// attribute name
        if(rs==null){
    %>
    <tr>
        <td>NO data !!!</td>
    </tr>
    <%}else{
        while(rs.next()) {
            out.println("<tr>" +
                    "<td>" + rs.getInt("ID")         + "</td>" +
                    "<td>" + rs.getString("Username")   + "</td>" +
                    "<td>" + rs.getString("Password")   + "</td>" +
                    "<td>" + rs.getString("Email")      + "</td>" +
                    "<td>" + rs.getString("Gender")     + "</td>" +
                    "<td>" + rs.getString("Birthdate")  +"</td>"  +
                    "</tr>"
            );
        }
    }%>
</table>

<%@include file="footer.jsp"%>
