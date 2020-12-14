package com.niu.blog.dao;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public void addComment(Comment comment) {
        Connection cn = null;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            String sql = "insert into comment (commentContent,commenterUserName,articleId) values(?,?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, comment.getCommentContent());
            st.setString(2, comment.getCommenterUserName());
            st.setString(3, String.valueOf(comment.getArticleId()));


            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }

    public List<Comment> findByArticleId(int articleId) {
        ArrayList<Comment> commentList = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from comment where articleId=?";

            st = cn.prepareStatement(sql);

            st.setString(1, String.valueOf(articleId));
            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setArticleId(rs.getInt("articleId"));
                comment.setCommenterUserName(rs.getString("commenterUserName"));
                comment.setCommentContent(rs.getString("commentContent"));
                comment.setCommentId(rs.getInt("commentId"));
                commentList.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return commentList;
    }
}
