<%--
  Created by IntelliJ IDEA.
  User: Flobby
  Date: 2023/3/7
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user_edit</title>
</head>
<body>
<form action="editUser" method="post" id="formId">
    <table>
        <tr>
            <td>选择</td>
            <td>用户名</td>
        </tr>
        <tr>
            <td>
                <input name="userList[0].id" value="1" type="checkbox">
            </td>
            <td>
                <input name="userList[0].name" value="flobby" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <input name="userList[1].id" value="2" type="checkbox">
            </td>
            <td>
                <input name="userList[1].name" value="jcx" type="text">
            </td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
