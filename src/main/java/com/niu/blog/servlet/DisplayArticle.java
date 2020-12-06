package com.niu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.Article;

import com.niu.blog.service.ArticleService;


@WebServlet("/displayArticle")
public class DisplayArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleService articleService = new ArticleService();

        List<Article> articleList = articleService.findAll();

        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/displayArticle.jsp").forward(request, response);
    }

}
