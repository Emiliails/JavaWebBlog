package com.niu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.Article;
import com.niu.blog.entity.ArticleType;
import com.niu.blog.service.ArticleService;
import com.niu.blog.service.ArticleTypeService;

@WebServlet("/addArticle")
public class AddArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("UserName");
        request.setAttribute("userName", userName);


        //获取当前用户的所有文章类型
        ArticleTypeService articleTypeService = new ArticleTypeService();
        List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
        request.setAttribute("articleTypeList", articleTypeList);

        request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        Article article = new Article();
        article.setUserName(request.getParameter("userName"));
        article.setArticleName(request.getParameter("articleName"));
        article.setArticleTypeName(request.getParameter("articleTypeName"));
        article.setArticleContent(request.getParameter("articleContent"));
        //2. 检查数据

        ArticleService articleService = new ArticleService();
        ArticleTypeService articleTypeService = new ArticleTypeService();

        //2.1 检查文章是否为空
        if (request.getParameter("articleName").equals("")) {
            request.setAttribute("article", article);
            request.setAttribute("userName", userName);
            request.setAttribute("errorMessage", "文章名不能为空！");
            //获取文章类型列表

            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
            return;
        }
        System.out.println(request.getParameter("articleTypeName"));
//        检查文章类型是否存在
        if (request.getParameter("articleTypeName")==null) {
            request.setAttribute("article", article);
            request.setAttribute("userName", userName);
            request.setAttribute("errorMessage", "文章类型不能为空！");
            //获取文章类型列表
            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
            return;
        }

        //3.-1 检查文章内容是否存在
        if (request.getParameter("articleContent").equals("")) {
            request.setAttribute("article", article);
            request.setAttribute("userName", userName);
            request.setAttribute("errorMessage", "文章内容不能为空！");
            //获取文章类型列表
            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
            return;
        }

        //3. 新加文章
        article = articleService.addArticle(article);

        request.setAttribute("article", article);
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }

}
