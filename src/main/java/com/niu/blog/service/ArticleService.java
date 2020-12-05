package com.niu.blog.service;

import com.niu.blog.dao.ArticleDao;
import com.niu.blog.entity.Article;

public class ArticleService {
    public Article addArticle(Article article) {
        ArticleDao articleDao = new ArticleDao();

        Article newArticle = articleDao.addArticle(article);

        //记录日志等。。。。。。

        return newArticle;
    }
}
