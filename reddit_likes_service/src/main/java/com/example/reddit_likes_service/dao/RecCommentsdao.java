package com.example.reddit_likes_service.dao;

import com.example.reddit_likes_service.models.CommentsReply;
import com.example.reddit_likes_service.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecCommentsdao extends JpaRepository<CommentsReply, Long> {

    List<CommentsReply> findByCommentId(Long CommentId);

}
