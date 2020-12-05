package com.niu.blog.service;

import com.niu.blog.dao.ArticleTypeDao;
import com.niu.blog.dao.UserDao;
import com.niu.blog.entity.ArticleType;

import java.util.List;

public class ArticleTypeService {

    public ArticleType addArticleType(ArticleType articleType) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();

        ArticleType newArticleType = articleTypeDao.addArticleType(articleType);

        //记录日志等。。。。。。

        return newArticleType;
    }

    public boolean exists(String userName, String articleTypeName) {
        ArticleType articleType = findByArticleTypeName(userName,articleTypeName);
        if (articleType == null)
            return false;
        else
            return true;
    }

    public ArticleType findByArticleTypeName(String userName, String articleTypeName) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        return articleTypeDao.findByArticleTypeName(userName,articleTypeName);
    }

    public List<ArticleType> findAll() {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();

        return articleTypeDao.findAll();
    }

    public List<ArticleType> findByUserName(String userName) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        return ArticleTypeDao.findByUserName(userName);
    }
}
