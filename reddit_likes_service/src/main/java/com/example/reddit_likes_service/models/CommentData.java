package com.example.reddit_likes_service.models;

import java.util.List;

public class CommentData {
    private List<Comment> comments;

    public CommentData(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
