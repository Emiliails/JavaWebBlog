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
		String userName = (String) request.getSession().getAttribute("UserName");
		
		if (userName == null || userName.equals(""))
			response.sendRedirect("login");
		
		UserService service = new UserService();
		User user = service.findByUserName(userName);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/modifyUserInformation.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setFullName(request.getParameter("fullName"));
				
		UserService service = new UserService();

		user = service.updateUser(user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/success.jsp").forward(request, response);

	}

}
