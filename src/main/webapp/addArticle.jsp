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
<h1>添加文章</h1>

<form action="addArticle" method="POST">
    <div class="form-group">
        <label for="userName">用户名</label>
        <input type="userName" class="form-control" id="userName" name="userName"
               value="${userName}" readonly>
    </div>
    <div class="form-group">
        <label for="articleName">文章名</label>
        <input type="articleName" class="form-control" id="articleName" name="articleName"
        value=${article.articleName}>
    </div>
    <div class="form-group">
        <label for="articleTypeName">文章类型</label>
        <select multiple class="form-control" id="articleTypeName" name="articleTypeName">
            <c:forEach items="${articleTypeList}" var="articleType">
                <option>${articleType.articleTypeName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="articleContent">文章内容</label>
        <input type="articleContent" class="form-control" id="articleContent" name="articleContent"
        value=${article.articleContent}>
    </div>
    <span style="color:red">${errorMessage}</span><br>
    <button type="submit" class="btn btn-primary">添加</button>
</form>
<%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
