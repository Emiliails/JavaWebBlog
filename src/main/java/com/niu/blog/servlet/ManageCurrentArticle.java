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


@WebServlet("/manageCurrentArticle")
public class ManageCurrentArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleService articleService = new ArticleService();
        String userName = (String) request.getSession().getAttribute("UserName");


        List<Article> articleList = articleService.findByUserName(userName);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/manageCurrentArticle.jsp").forward(request, response);
    }

}
