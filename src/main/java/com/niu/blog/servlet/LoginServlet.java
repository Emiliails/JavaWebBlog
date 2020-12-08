package com.niu.blog.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niu.blog.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取用户名和密码
        //request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        String msg = userService.loginVerify(userName, password);

        if (msg.equals("success")) {
            HttpSession session = request.getSession();
            session.setAttribute("UserName", userName);
            response.sendRedirect("main?msg=" + msg);
        } else {
            request.setAttribute("userName", userName);
			request.setAttribute("errorMessage", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

//		//2.检查用户名和密码正确性
//		if (request.getParameter("userName").equals("")){
//			request.setAttribute("errorMessage", "用户名不能为空！");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//			return;
//		}
//
//		UserService service = new UserService();
//		if (service.exists(userName) && service.loginVerify(userName, password)){
//			//3.正确转主页面的控制器
//			String msg = ":)";
////			msg = URLEncoder.encode(msg,"utf-8");
//
//			//3.1 保存用户名到会话中
//			HttpSession session = request.getSession();
//			session.setAttribute("UserName", userName);
//
//			response.sendRedirect("main?msg=" + msg);
//		}else{
//			//4.失败转登录页面
//			request.setAttribute("userName", userName);
//			request.setAttribute("errorMessage", "用户名或密码错误！");
//
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//		}
    }

}
