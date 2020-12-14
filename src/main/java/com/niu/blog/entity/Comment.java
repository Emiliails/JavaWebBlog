package com.niu.blog.entity;

public class Comment {
    private int commentId;
    private String commenterUserName;
    private String commentContent;
    private int articleId;

    public Comment() {
    }

    public String getCommenterUserName() {
        return commenterUserName;
    }

    public void setCommenterUserName(String commenterUserName) {
        this.commenterUserName = commenterUserName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}
