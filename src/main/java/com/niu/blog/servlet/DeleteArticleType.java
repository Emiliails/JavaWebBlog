package com.niu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.blog.dao.ArticleTypeDao;
import com.niu.blog.entity.Article;
import com.niu.blog.entity.ArticleType;
import com.niu.blog.service.ArticleService;
import com.niu.blog.service.ArticleTypeService;

@WebServlet("/deleteArticleType")
public class DeleteArticleType extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("UserName");
        request.setAttribute("userName", userName);


        //获取当前用户的所有文章类型
        ArticleTypeService articleTypeService = new ArticleTypeService();
        List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
        request.setAttribute("articleTypeList", articleTypeList);

        request.getRequestDispatcher("/deleteArticleType.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = (String) request.getSession().getAttribute("UserName");
        String articleTypeName = request.getParameter("articleTypeName");
//        ArticleType articleType = new ArticleType();
//        articleType.setUserName(userName);
//        System.out.println(userName);

        ArticleTypeService articleTypeService = new ArticleTypeService();


//        检查选取的文章类型是否为空
        if (request.getParameter("articleTypeName") == null) {

            request.setAttribute("errorMessage", "待删除的文章类型不能为空！");
            //获取文章类型列表
            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/deleteArticleType.jsp").forward(request, response);
            return;
        }


        //3.-1 检查文章类型是否被占用
        ArticleService articleService = new ArticleService();
        if (articleService.findByArticleTypeNameAndUserName(articleTypeName,userName) != null){
            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);
            request.setAttribute("errorMessage", "文章类型已经被占用！");
            request.getRequestDispatcher("/deleteArticleType.jsp").forward(request, response);
            return;
        }


//        删除文章类型
        articleTypeService.deleteArticleType(articleTypeName,userName);


        List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
        System.out.println(articleTypeList);
        request.setAttribute("articleTypeList", articleTypeList);
        request.getRequestDispatcher("/deleteArticleType.jsp").forward(request, response);
    }

}
