<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%--
<div id="header" style="background-color:gray">
	<h1 style="text-align:center;color:white">个人博客</h1>
</div>
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="main">博客</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="main">主页 <span class="sr-only">(current)</span></a>
            </li>
            <%--			<li class="nav-item">--%>
            <%--				<a class="nav-link" href="">文章</a>--%>
            <%--			</li>--%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="ArticleDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    文章
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="addArticleType">添加文章类型</a>
                    <a class="dropdown-item" href="displayArticleType">查看文章类型</a>
                    <a class="dropdown-item" href="modifyArticleType">修改文章类型</a>
                    <a class="dropdown-item" href="deleteArticleType">删除文章类型</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="addArticle">添加文章</a>
                    <a class="dropdown-item" href="manageArticle">管理文章</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="UserDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    我的
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="displayCurrentUser">个人信息</a>
                    <a class="dropdown-item" href="modifyCurrentUserInformation">修改个人信息</a>
                    <a class="dropdown-item" href="modifyUserPassword">修改个人密码</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="ManagerDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    管理员
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="manageUsers">管理用户</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">注销</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
        </form>
    </div>
</nav>
