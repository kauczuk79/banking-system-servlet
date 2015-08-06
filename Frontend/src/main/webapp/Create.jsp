<%--
  Created by IntelliJ IDEA.
  User: rowesolowski
  Date: 2015-08-06
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Create User</h1>
<form method="post" action="<%=request.getContextPath()%>/create" accept-charset="UTF-8">
  First name <input type="text" name="FirstName"><br>
  Last name <input type="text" name="LastName"><br>
  <input type="submit" value="Create">
</form>
</body>
</html>
