<h1>登录结果页面</h1>
<h2>${msg}</h2>

<#if code == 0>
    用户名：${username}
    密码：${password}
</#if>

<#if code  == 1>
    <a href="login.html" >重新登录</a>
</#if>