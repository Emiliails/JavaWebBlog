package com.niu.blog.servlet;

import com.niu.blog.entity.Article;
import com.niu.blog.entity.Comment;
import com.niu.blog.service.ArticleService;
import com.niu.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/displayArticle")
public class DisplayArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));

        ArticleService articleService = new ArticleService();
        Article article = articleService.findByArticleId(articleId);

        String articleContent = article.getArticleContent();
        articleContent = articleContent.replaceAll("\r\n", "<br/>");
        article.setArticleContent(articleContent);

        request.setAttribute("article", article);

        String commenterUserName = (String) request.getSession().getAttribute("UserName");
        request.setAttribute("commenterUserName", commenterUserName);

        List<Comment> commentList = new CommentService().findByArticleId(articleId);
        request.setAttribute("commentList", commentList);


        request.getRequestDispatcher("/displayArticle.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String commenterUserName = request.getParameter("commenterUserName");
        String commentContent = request.getParameter("commentContent");
        String articleId = request.getParameter("articleId");

        Comment comment = new Comment();
        comment.setCommenterUserName(commenterUserName);
        comment.setCommentContent(commentContent);
        comment.setArticleId(Integer.parseInt(articleId));
        CommentService commentService = new CommentService();
        commentService.addComment(comment);

        response.sendRedirect("displayArticle?articleId=" + articleId);

    }
}
