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

    public Article updateArticle(Article article) {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.updateArticle(article);
    }

    public List<Article> findByArticleNameLike(String articleNameLike) {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByArticleNameLike(articleNameLike);
    }

    public List<Article> findByUserNameAndArticleTypeName(String userName, String articleTypeName) {
        ArticleDao articleDao = new ArticleDao();
        return  articleDao.findByUserNameAndArticleTypeName(userName,articleTypeName);
    }
}
