<%--
  Created by IntelliJ IDEA.
  User: Flobby
  Date: 2023/3/7
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <form action="deleteUsers" method="post">
        <table>
            <tr>
                <td>选择</td>
                <td>用户名</td>
            </tr>
            <tr>
                <td><input name="ids" value="1" type="checkbox"></td>
                <td>tom</td>
            </tr>
            <tr>
                <td><input name="ids" value="2" type="checkbox"></td>
                <td>jack</td>
            </tr>
            <tr>
                <td><input name="ids" value="3" type="checkbox"></td>
                <td>lucy</td>
            </tr>
        </table>
        <input type="submit" value="删除">
    </form>
</body>
</html>
