package com.niu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.User;
import com.niu.blog.service.UserService;

@WebServlet("/displayCurrentUser")
public class DisplayCurrentUser extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String) request.getSession().getAttribute("UserName");
		
		
		//登录验证功能在登录验证过滤器中实现
		//if (userName == null || userName.equals(""))
			//response.sendRedirect("login");
		
		UserService service = new UserService();
		User user = service.findByUserName(userName);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/displayUserInformation.jsp").forward(request, response);
	}

}
