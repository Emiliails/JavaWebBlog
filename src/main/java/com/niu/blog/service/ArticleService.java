package com.niu.blog.service;

import com.niu.blog.dao.ArticleDao;
import com.niu.blog.dao.UserDao;
import com.niu.blog.entity.Article;

import java.util.List;

public class ArticleService {
    public Article addArticle(Article article) {
        ArticleDao articleDao = new ArticleDao();

        Article newArticle = articleDao.addArticle(article);

        //记录日志等。。。。。。

        return newArticle;
    }

    public List<Article> findAll() {
        UserDao userDao = new UserDao();
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findAll();
    }
}
