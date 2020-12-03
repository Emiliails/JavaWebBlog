package com.niu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.User;
import com.niu.blog.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 接收表单数据
		//使用编码转换过滤器拦截request请求并转换编码，不在servlet中处理了
		//request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setFullName(request.getParameter("fullName"));
		//2. 检查数据
		
		UserService service = new UserService();
		
		//2.1 检查用户名密码是否为空，两密码是否相等
		if (request.getParameter("userName")==""){
			request.setAttribute("errorMessage", "用户名不能为空！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if (request.getParameter("password")==""){
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", "密码不能为空！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if (!request.getParameter("password").equals(request.getParameter("passwordAgain"))){
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", "两次输入的密码不相同！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		//3.-1 检查用户是否存在
		if (service.exists(user.getUserName())){
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", "用户名已经存在！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		
		//3. 新加用户
		user = service.addUser(user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
