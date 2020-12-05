<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'success.jsp' starting page</title>

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
<h1>主页面</h1>
<br>${msg}<br>

<a href="displayUserInformation">个人信息</a>
<a href="modifyUserInformation">修改个人信息</a>
<a href="modifyUserPassword">修改个人密码</a>
<a href="addArticleType">添加文章类型</a>
<a href="displayArticleType">查看文章类型</a>
<a href="logout">注销</a>

<a href="manageUsers">管理用户</a>
<%@include file="layout/footer.jsp" %>
</body>
</html>
