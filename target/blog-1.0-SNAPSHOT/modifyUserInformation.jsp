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
<%--<form action="modifyUserInformation" method="post">--%>
<%--    <input type="hidden" name="userName" value="${user.userName}">--%>

<%--    用户名：${user.userName}<br>--%>
<%--    用户全名：<input type="text" name="fullName" value="${user.fullName}"><br>--%>
<%--    <span style="color:red">${errorMessage}</span><br>--%>
<%--    <input type="submit" value="保存">--%>
<%--</form>--%>

<form action="modifyUserInformation" method="POST">
    <div class="form-group">
        <label for="userName">用户名</label>
        <input type="userName" class="form-control" id="userName" name="userName"
               value="${user.userName}" readonly>
    </div>
    <div class="form-group">
        <label for="fullName">姓名</label>
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
        <label for="birthday">生日</label>
        <input type="text" class="form-control" id="birthday" name="birthday" value="${user.birthday}">
    </div>
    <div class="form-group">
        <label for="phone">手机</label>
        <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" value="${user.email}">
    </div>
    <div class="form-group">
        <label for="weChatId">微信号</label>
        <input type="text" class="form-control" id="weChatId" name="weChatId" value="${user.weChatId}">
    </div>
    <div class="form-group">
        <label for="description">描述信息</label>
        <input type="text" class="form-control" id="description" name="description" value="${user.description}">
    </div>
    <span style="color:red">${errorMessage}</span><br>
    <button type="submit" class="btn btn-primary">提交修改</button>
</form>

<%@include file="layout/footer.jsp" %>
</body>
</html>
