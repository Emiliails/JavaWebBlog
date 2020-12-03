<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body>
<%@include file="layout/header.jsp" %>
<h1>用户注册</h1>
<form action="register" method="post">
    用户名：<input type="text" name="userName" value="${user.userName}"><br>
    密码：<input type="password" name="password"><br>
    再次输入密码：<input type="password" name="passwordAgain"><br>
    用户全名：<input type="text" name="fullName" value="${user.fullName}"><br>
    <span style="color:red">${errorMessage}</span><br>
    <input type="submit" value="注册">
</form>
<%@include file="layout/footer.jsp" %>
</body>
</html>
