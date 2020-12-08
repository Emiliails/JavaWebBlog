package com.niu.blog.dao;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.Article;
import com.niu.blog.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Article> findAll() {
        ArrayList<Article> articleList = new ArrayList<>();

        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from article";
            st = cn.prepareStatement(sql);

            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                Article article = new Article();
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                articleList.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return articleList;
    }

    public Article findByArticleTypeNameAndUserName(String articleTypeName, String userName) {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        try {
            //4.执行sql
            String sql = "select * from article where articleTypeName=? and username=?";

            st = cn.prepareStatement(sql);

            st.setString(1, articleTypeName);
            st.setString(2, userName);
            System.out.println(st);

            rs = st.executeQuery();
            if (rs.next()) {
                Article article = new Article();
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                return article;
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

    public List<Article> findByUserName(String userName) {
        ArrayList<Article> articleList = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        try {
            //4.执行sql
            String sql = "select * from article where username=?";

            st = cn.prepareStatement(sql);

            st.setString(1, userName);
            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setArticleId(rs.getInt("articleId"));
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                articleList.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return articleList;
    }

    public Article findByArticleId(int articleId) {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from article where articleId=?";

            st = cn.prepareStatement(sql);

            st.setString(1, String.valueOf(articleId));
            System.out.println(st);

            rs = st.executeQuery();
            if (rs.next()) {
                Article article = new Article();
                article.setArticleId(rs.getInt("articleId"));
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                return article;
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

    public void deleteByArticleId(int articleId) {
        Connection cn = null;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            //4.执行sql
            String sql = "delete from article where articleId=?";
            st = cn.prepareStatement(sql);

            st.setString(1, String.valueOf(articleId));

            System.out.println(st);
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }

    public Article updateArticle(Article article) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
//            String sql = "insert into article(articleName,userName,articleTypeName,articleContent) values(?,?,?,?)";
            String sql = "update article set articleName=?,articleTypeName=?,articleContent=? where articleId=?";
            st = cn.prepareStatement(sql);

            st.setString(1, article.getArticleName());
            st.setString(2, article.getArticleTypeName());
            st.setString(3, article.getArticleContent());
            st.setString(4, String.valueOf(article.getArticleId()));

            System.out.println(st);
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
