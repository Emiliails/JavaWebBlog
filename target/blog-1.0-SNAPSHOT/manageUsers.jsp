<%@ page language="java" import="java.util.*" import="com.niu.blog.entity.User" pageEncoding="utf-8" %>
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
<%@include file="layout/header.jsp" %>
<%
    List<User> userList = (List<User>) request.getAttribute("userList");
%>
<table border="1">
    <tr>
        <th></th>
        <th>用户名</th>
        <th>全名</th>
        <th></th>
    </tr>
    <%
        for (int i = 0; i < userList.size(); i++) {
    %>
    <tr>
        <td><input type="checkbox" value="<%=userList.get(i).getUserName()%>" name="userName"></td>
        <td><%=userList.get(i).getUserName()%>
        </td>
        <td><%=userList.get(i).getFullName()%>
        </td>
        <td><a href="displayUser?userName=<%=userList.get(i).getUserName()%>">详细</a></td>
    </tr>
    <%
        }
    %>
</table>
<%@include file="layout/footer.jsp" %>
</body>
</html>
