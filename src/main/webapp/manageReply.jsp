<%@ page language="java" import="java.util.*" import="com.niu.blog.entity.User" pageEncoding="utf-8" %>
<%@ page import="com.niu.blog.entity.ArticleType" %>
<%@ page import="com.niu.blog.entity.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'manageUsers.jsp' starting page</title>

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
    <h1>查看回复</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>回复号</th>
            <th>评论号</th>
            <th>回复者</th>
            <th>回复内容</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${replyList}" var="reply">
            <tr>
                <td>${reply.replyId}</td>
                <td>${reply.commentId}</td>
                <td>${reply.replyUserName}</td>
                <td>${reply.replyContent}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
