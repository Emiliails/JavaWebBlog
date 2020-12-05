package com.niu.blog.dao;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleDao {
    public Article addArticle(Article article) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            String sql = "insert into article(articleName,userName,articleTypeName,articleContent) values(?,?,?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, article.getArticleName());
            st.setString(2, article.getUserName());
            st.setString(3, article.getArticleTypeName());
            st.setString(4, article.getArticleContent());


            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return article;
    }
}
