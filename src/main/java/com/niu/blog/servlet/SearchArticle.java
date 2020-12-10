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

@WebServlet("/searchArticle")
public class SearchArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/searchArticle.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String articleNameLike =  request.getParameter("articleNameLike");

        ArticleService articleService = new ArticleService();
        List<Article> articleList = articleService.findByArticleNameLike(articleNameLike);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/searchArticle.jsp").forward(request, response);
    }

}
