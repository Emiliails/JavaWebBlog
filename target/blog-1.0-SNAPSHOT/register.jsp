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
<%--<form action="register" method="post">--%>
<%--    用户名：<input type="text" name="userName" value="${user.userName}"><br>--%>
<%--    密码：<input type="password" name="password"><br>--%>
<%--    再次输入密码：<input type="password" name="passwordAgain"><br>--%>
<%--    用户全名：<input type="text" name="fullName" value="${user.fullName}"><br>--%>
<%--    <span style="color:red">${errorMessage}</span><br>--%>
<%--    <input type="submit" value="注册">--%>
<%--</form>--%>

<form action="register" method="POST">
    <div class="form-group">
        <label for="userName">用户名</label>
        <input type="userName" class="form-control" id="userName" aria-describedby="userNameHelp" name="userName"
               value="${user.userName}">
        <small id="userNameHelp" class="form-text text-muted">用户名长度在3-12之间</small>
    </div>
    <div class="form-group">
        <label for="fullName">用户全名</label>
        <input type="fullName" class="form-control" id="fullName" name="fullName"
               value="${user.fullName}">
    </div>
    <div class="form-group">
        <label for="gender">性别</label>
        <select class="form-control" id="gender" name="gender">
            <option>男</option>
            <option>女</option>
            <option>其他</option>
        </select>
    </div>
    <div class="form-group">
        <label for="age">年龄</label>
        <input type="text" class="form-control" id="age" name="age" value="${user.age}">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" value="${user.email}">
    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <div class="form-group">
        <label for="passwordAgain">再次输入密码</label>
        <input type="password" class="form-control" id="passwordAgain" name="passwordAgain">
    </div>
    <span style="color:red">${errorMessage}</span><br>
    <button type="submit" class="btn btn-primary">注册</button>
</form>
<%@include file="layout/footer.jsp" %>
</body>
</html>
