package com.example.reddit_likes_service.dao;

import com.example.reddit_likes_service.models.Comment;
import com.example.reddit_likes_service.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Commentsdao extends JpaRepository<Comment, Long> {

    List<Comment> findByPostid(Long Postid);
}
