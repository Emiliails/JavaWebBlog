<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.niu.blog.entity.ArticleType" %>
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
    <h1>删除文章类型</h1>
    <form action="deleteArticleType" method="post">
        <div class="form-group">
            <label for="articleTypeName">选择要删除的文章类型</label>
            <select multiple class="form-control" id="articleTypeName" name="articleTypeName">
                <c:forEach items="${articleTypeList}" var="articleType">
                    <option>${articleType.articleTypeName}</option>
                </c:forEach>
            </select>
        </div>
        <span style="color:red">${errorMessage}</span><br>
        <button type="submit" class="btn btn-primary">删除文章类型</button>
    </form>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
