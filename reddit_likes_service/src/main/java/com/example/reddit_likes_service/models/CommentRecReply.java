package com.example.reddit_likes_service.models;

import java.util.ArrayList;
import java.util.List;

public class CommentRecReply {

    private Comment comment;
    private List<Comment> commentRecReplies = new ArrayList<>();

    public CommentRecReply(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment= comment;
    }

    public List<Comment> getCommentRecReplies() {
        return commentRecReplies;
    }

    public void setCommentRecReplies(Comment commentRecReplies) {
        this.commentRecReplies.add(commentRecReplies);
    }
}
