package com.niu.blog.service;

import com.niu.blog.dao.ArticleTypeDao;
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
        ArticleType articleType = findByArticleTypeNameAndUserName(userName,articleTypeName);
        if (articleType == null)
            return false;
        else
            return true;
    }

    public ArticleType findByArticleTypeNameAndUserName(String userName, String articleTypeName) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        return articleTypeDao.findByArticleTypeNameAndUserName(userName,articleTypeName);
    }

    public List<ArticleType> findAll() {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();

        return articleTypeDao.findAll();
    }

    public List<ArticleType> findByUserName(String userName) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        return ArticleTypeDao.findByUserName(userName);
    }

    public ArticleType updateArticleType(String articleName,ArticleType articleType) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        return articleTypeDao.updateArticleType(articleName,articleType);
    }

    public void deleteArticleType(String articleTypeName, String userName) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        articleTypeDao.deleteArticleType(articleTypeName,userName);
    }
}
