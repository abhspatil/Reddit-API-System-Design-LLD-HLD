package com.reddit.api.model;

import java.util.List;

public class CommentData {
    private List<Comment> comments;

    public CommentData() {
    }

    public CommentData(List<Comment> commentList) {
        this.comments = commentList;
    }

    public List<Comment> getCommentList() {
        return comments;
    }

    public void setCommentList(List<Comment> commentList) {
        this.comments = commentList;
    }
}
