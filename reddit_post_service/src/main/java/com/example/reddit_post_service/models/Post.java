package com.example.reddit_post_service.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long post_id;

    private long user_id;
    private String title;
    private String description;
    private Date created_at;

    public Post() { }

    public Post(long post_id, long user_id, String title, String description, Date created_at) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
