package com.niu.blog.dao;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.Reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDao {
    public void addReply(Reply reply) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
//            String sql = "insert into article(articleName,userName,articleTypeName,articleContent,articleCreateDate) values(?,?,?,?,?)";
            String sql = "insert into reply(commentId, replyUserName, replyContent) values (?,?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, String.valueOf(reply.getCommentId()));
            st.setString(2, reply.getReplyUserName());
            st.setString(3, reply.getReplyContent());

            System.out.println(st);

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }

    public List<Reply> findByCommentId(String commentId) {
//        ArrayList<Article> articleList = new ArrayList<>();
        ArrayList<Reply> replyList = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from reply where commentId=?";

            st = cn.prepareStatement(sql);

            st.setString(1, commentId);
            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                Reply reply = new Reply();
                reply.setReplyId(rs.getInt("replyId"));
                reply.setCommentId(rs.getInt("commentId"));
                reply.setReplyUserName(rs.getString("replyUserName"));
                reply.setReplyContent(rs.getString("replyContent"));
                System.out.println(reply.getReplyId());
                System.out.println(reply.getReplyUserName());
                System.out.println(reply.getCommentId());
                System.out.println(reply.getReplyContent());
                replyList.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return replyList;
    }
}
