package com.niu.blog.service;

import com.niu.blog.dao.ArticleTypeDao;
import com.niu.blog.entity.ArticleType;

public class ArticleTypeService {

    public ArticleType addArticleType(ArticleType articleType) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();

        ArticleType newArticleType = articleTypeDao.addArticleType(articleType);

        //记录日志等。。。。。。

        return newArticleType;
    }

    public boolean exists(String articleTypeName) {
        ArticleType articleType = findByArticleTypeName(articleTypeName);
        if (articleType == null)
            return false;
        else
            return true;
    }

    public ArticleType findByArticleTypeName(String articleTypeName) {
        ArticleTypeDao articleTypeDao = new ArticleTypeDao();
        return articleTypeDao.findByArticleTypeName(articleTypeName);
    }
}
