package com.example.reddit_likes_service.dao;

import com.example.reddit_likes_service.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRecdao extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostid(Long post_id);
}
