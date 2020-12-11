package com.niu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.User;
import com.niu.blog.service.UserService;

@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/searchUser.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullNameOrDescriptionLike = request.getParameter("fullNameOrDescriptionLike");

        UserService userService = new UserService();
        List<User> userList = userService.findByFullNameOrDescriptionLike(fullNameOrDescriptionLike);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/searchUser.jsp").forward(request, response);
    }

}
