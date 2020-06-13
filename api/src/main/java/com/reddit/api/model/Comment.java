package com.reddit.api.model;

import java.util.Date;

public class Comment {

    private Long id;

    private Long postid;
    private String content;
    private Long user_id;
    private Date created_at;

    public Comment() {
    }

    public Comment(Long id, Long post_id, String content, Long user_id, Date created_at) {
        this.id = id;
        this.postid = post_id;
        this.content = content;
        this.user_id = user_id;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPost_id() {
        return postid;
    }

    public void setPost_id(Long post_id) {
        this.postid = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
