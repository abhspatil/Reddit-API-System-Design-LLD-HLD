package com.reddit.api.model;

public class Feed {

    private Post post;
    private CommentData comments;
    private LikesData likes;

    public Feed(){}

    public Feed(Post post, CommentData comments, LikesData likes) {
        this.post = post;
        this.comments = comments;
        this.likes = likes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public CommentData getComments() {
        return comments;
    }

    public void setComments(CommentData comments) {
        this.comments = comments;
    }

    public LikesData getLikes() {
        return likes;
    }

    public void setLikes(LikesData likes) {
        this.likes = likes;
    }
}
