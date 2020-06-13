package com.reddit.api.model;

import java.io.Serializable;

public class Like implements Serializable {

    private Long Id;

    private Long postid;
    private Long user_id;

    public Like() {
    }

    public Like(Long id, Long post_id, Long user_id) {
        Id = id;
        this.postid = post_id;
        this.user_id = user_id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getPost_id() {
        return postid;
    }

    public void setPost_id(Long post_id) {
        this.postid = post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
