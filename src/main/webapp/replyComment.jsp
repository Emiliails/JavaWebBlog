<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.niu.blog.entity.ArticleType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="container">
    <%@include file="layout/header.jsp" %>
    <h1>回复评论</h1>

    <form action="replyComment" method="POST">
        <div class="form-group">
            <label for="replyUserName">回复者</label>
            <input type="text" class="form-control" id="replyUserName" name="replyUserName"
                   value=${replyUserName} readonly>
        </div>
        <div class="form-group">
            <label for="commentId">评论号</label>
            <input type="text" class="form-control" id="commentId" name="commentId"
                   value=${commentId} readonly>
        </div>
        <div class="form-group">
            <label for="replyContent">回复内容</label>
            <textarea class="form-control" id="replyContent" name="replyContent"></textarea>
        </div>
        <span style="color:red">${errorMessage}</span><br>
        <button type="submit" class="btn btn-primary">回复</button>
    </form>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
