package com.example.reddit_likes_service.models;

import java.util.List;

public class LikesData {

    private List<Like> likes;

    public LikesData(List<Like> likeList) {
        this.likes = likeList;
    }

    public List<Like> getLikeList() {
        return likes;
    }

    public void setLikeList(List<Like> likeList) {
        this.likes = likeList;
    }
}
