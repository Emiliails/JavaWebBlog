package com.niu.blog.service;

import com.niu.blog.dao.CommentDao;
import com.niu.blog.entity.Comment;

import java.util.List;

public class CommentService {
    public void addComment(Comment comment) {
        CommentDao commentDao = new CommentDao();
        commentDao.addComment(comment);
    }

    public List<Comment> findByArticleId(int articleId) {
        CommentDao commentDao = new CommentDao();
        return commentDao.findByArticleId(articleId);
    }
}
