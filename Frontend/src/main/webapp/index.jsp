<%--
  Created by IntelliJ IDEA.
  User: rowesolowski
  Date: 2015-08-05
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <h1>Login</h1>
    <form method="post" action="<%=request.getContextPath()%>/login" accept-charset="UTF-8">
      First name <input type="text" name="FirstName" value="Robert"><br>
      Last name <input type="text" name="LastName" value="Wesolowski"><br>
      Secret password ("123456") <input type="text" name="Password" value="123456"><br>
      <input type="submit" value="Login">
    </form>
  </body>
</html>
