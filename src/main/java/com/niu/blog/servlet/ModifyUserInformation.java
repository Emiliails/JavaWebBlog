package com.niu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.User;
import com.niu.blog.service.UserService;

@WebServlet("/modifyUserInformation")
public class ModifyUserInformation extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        //登录验证功能在登录过滤器中实现
//		if (userName == null || userName.equals(""))
//			response.sendRedirect("login");

        UserService service = new UserService();
        User user = service.findByUserName(userName);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/modifyUserInformation.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        request.setCharacterEncoding("utf-8");
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setFullName(request.getParameter("fullName"));
        user.setGender(request.getParameter("gender"));
        user.setBirthday(request.getParameter("birthday"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        user.setWeChatId(request.getParameter("weChatId"));
        user.setDescription(request.getParameter("description"));
        user.setRegistrationDate(request.getParameter("registrationDate"));

        UserService service = new UserService();

        user = service.updateUser(user);

        response.sendRedirect("manageUsers");
//        request.setAttribute("user", user);
//        request.getRequestDispatcher("/success.jsp").forward(request, response);

    }

}
