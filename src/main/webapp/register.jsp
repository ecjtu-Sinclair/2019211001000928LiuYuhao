<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2021/3/15
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
This is my Register JSP page.
<form method="post" action="register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female <br/>
    Date of Birth:<input type="text" name="birthDate"><br/>
    <input type="submit" name="Register"/>
</form>
<%@include file="footer.jsp"%>
