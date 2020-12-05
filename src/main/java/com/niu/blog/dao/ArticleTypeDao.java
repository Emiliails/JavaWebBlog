package com.niu.blog.dao;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.ArticleType;
import com.niu.blog.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleTypeDao {
    public ArticleType findByArticleTypeName(String articleTypeName) {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from articleTypes where articleTypeName=?";
            st = cn.prepareStatement(sql);

            st.setString(1, articleTypeName);

            rs = st.executeQuery();
            if (rs.next()) {
                ArticleType articleType = new ArticleType();
                articleType.setArticleTypeName(articleTypeName);
                articleType.setUserName(rs.getString("userName"));
                return articleType;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return null;
    }

    public ArticleType addArticleType(ArticleType articleType) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            String sql = "insert into articleTypes(articleTypeName,userName) values(?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, articleType.getArticleTypeName());
            st.setString(2, articleType.getUserName());


            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return articleType;
    }
}
