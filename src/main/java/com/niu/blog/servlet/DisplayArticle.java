package com.niu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.Article;
import com.niu.blog.entity.User;
import com.niu.blog.service.ArticleService;
import com.niu.blog.service.UserService;

@WebServlet("/displayArticle")
public class DisplayArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));

        ArticleService articleService = new ArticleService();
        Article article = articleService.findByArticleId(articleId);

        String articleContent = article.getArticleContent();
        articleContent = articleContent.replaceAll("\r\n","<br/>");
        article.setArticleContent(articleContent);

        request.setAttribute("article", article);
        request.getRequestDispatcher("/displayArticle.jsp").forward(request, response);
    }

}
