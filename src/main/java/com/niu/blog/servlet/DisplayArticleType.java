package com.niu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.entity.ArticleType;

import com.niu.blog.service.ArticleTypeService;


@WebServlet("/displayArticleType")
public class DisplayArticleType extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleTypeService articleTypeService = new ArticleTypeService();

        List<ArticleType> articleTypeList = articleTypeService.findAll();

        request.setAttribute("articleTypeList", articleTypeList);
        request.getRequestDispatcher("/displayArticleType.jsp").forward(request, response);
    }

}
