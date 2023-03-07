<%--
  Created by IntelliJ IDEA.
  User: Flobby
  Date: 2023/3/7
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h2>注册</h2>
<form action="registerUser" method="post">
  <label>
    用户名：
    <input type="text" name="name">
  </label>
  <br>
  <label>
    密码：
    <input type="password" name="password">
  </label>
  <br>
  <input type="submit" value="注册">
</form>
</body>
</html>
