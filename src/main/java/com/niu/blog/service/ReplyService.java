package com.niu.blog.service;

import com.niu.blog.dao.ReplyDao;
import com.niu.blog.entity.Reply;

import java.util.List;

public class ReplyService {
    public void addReply(Reply reply) {
        ReplyDao replyDao = new ReplyDao();
        replyDao.addReply(reply);
    }

    public List<Reply> findByCommentId(String commentId) {
        ReplyDao replyDao = new ReplyDao();
        return replyDao.findByCommentId(commentId);
    }
}
