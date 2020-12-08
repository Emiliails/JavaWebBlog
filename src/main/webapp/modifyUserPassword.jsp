<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <base href="<%=basePath%>">

    <title>My JSP 'modifyUserPassword.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body>
<div class="container">
    <%@include file="layout/header.jsp" %>
    <%--    <form action="modifyUserPassword" method="post">--%>
    <%--        <input type="hidden" name="userName" value="${user.userName}">--%>

    <%--        用户名：${user.userName}<br>--%>
    <%--        密码：<input type="password" name="password" value="${user.password}"><br>--%>
    <%--        <span style="color:red">${errorMessage}</span><br>--%>
    <%--        <input type="submit" value="保存">--%>
    <%--    </form>--%>
    <h1>修改密码</h1>
    <form action="modifyUserPassword" method="post">
        <div class="form-group">
            <label for="userName">用户名</label>
            <input type="text" class="form-control" id="userName" name="userName"
                   value="${user.userName}" readonly>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <span style="color:red">${errorMessage}</span><br>
        <button type="submit" class="btn btn-primary">修改</button>
    </form>
    <%@include file="layout/footer.jsp" %>
</div>
</body>

</html>