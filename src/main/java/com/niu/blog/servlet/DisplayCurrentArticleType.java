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


@WebServlet("/displayCurrentArticleType")
public class DisplayCurrentArticleType extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = (String) request.getSession().getAttribute("UserName");
        ArticleTypeService articleTypeService = new ArticleTypeService();

//        List<ArticleType> articleTypeList = articleTypeService.findAll();
        List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
        request.setAttribute("articleTypeList", articleTypeList);
        request.getRequestDispatcher("/displayArticleType.jsp").forward(request, response);
    }

}
