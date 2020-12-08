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

    public Article findByArticleTypeNameAndUserName(String articleTypeName, String userName) {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByArticleTypeNameAndUserName(articleTypeName,userName);
    }

    public List<Article> findByUserName(String userName) {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByUserName(userName);
    }

    public Article findByArticleId(int articleId) {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByArticleId(articleId);
    }

    public void deleteByArticleId(int articleId) {
        ArticleDao articleDao = new ArticleDao();
        articleDao.deleteByArticleId(articleId);
    }
}
