package com.niu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.ArticleType;
import com.niu.blog.service.ArticleTypeService;

@WebServlet("/addArticleType")
public class AddArticleType extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("UserName");
        request.setAttribute("userName", userName);
        request.getRequestDispatcher("/addArticleType.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1. 接收表单数据
        //使用编码转换过滤器拦截request请求并转换编码，不在servlet中处理了
        //request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");

        ArticleType articleType = new ArticleType();
        articleType.setUserName(request.getParameter("userName"));
        articleType.setArticleTypeName(request.getParameter("articleTypeName"));
        //2. 检查数据

        ArticleTypeService articleTypeService = new ArticleTypeService();

        //2.1 检查文章类型是否为空
        if (request.getParameter("articleTypeName").equals("")){
            request.setAttribute("userName",userName);
            request.setAttribute("errorMessage", "文章类型不能为空！");
            request.getRequestDispatcher("/addArticleType.jsp").forward(request, response);
            return;
        }

        //3.-1 检查文章类型是否存在
        if (articleTypeService.exists(userName,articleType.getArticleTypeName())){
            request.setAttribute("userName",userName);
            request.setAttribute("errorMessage", "文章类型已经存在！");
            request.getRequestDispatcher("/addArticleType.jsp").forward(request, response);
            return;
        }

        //3. 新加文章类型
        articleType = articleTypeService.addArticleType(articleType);

        request.setAttribute("articleType", articleType);
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }

}
