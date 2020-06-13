package com.example.reddit_likes_service.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rec_comments")
public class CommentsReply {
    @Id
    @GeneratedValue
    private Long id;

    private Long commentId;
    private Long replyId;

    public CommentsReply(){}

    public CommentsReply(Long commentId, Long replyId) {
        this.commentId = commentId;
        this.replyId = replyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }
}
