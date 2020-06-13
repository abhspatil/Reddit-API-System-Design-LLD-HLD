package com.example.reddit_likes_service.controller;

import com.example.reddit_likes_service.dao.Commentsdao;
import com.example.reddit_likes_service.dao.Likesdao;
import com.example.reddit_likes_service.models.Comment;
import com.example.reddit_likes_service.models.CommentData;
import com.example.reddit_likes_service.models.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comments/",produces = "application/hal+json")
public class CommentsController {

    @Autowired
    private Commentsdao repository;

    @PostMapping
    public Comment create(@RequestBody Comment comment){
        comment.setCreated_at(new Date());
        return repository.save(comment);
    }

    @GetMapping("{id}")
    public CommentData get(@PathVariable(value = "id") Long post_id){
        List<Comment> comments = repository.findByPostid(post_id);

        return new CommentData(comments);
    }

    @GetMapping
    public List<Comment> getAll(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean>  delete(@PathVariable(value = "id") Long cmtId) throws Exception{
        Comment like = repository.findById(cmtId)
                        .orElseThrow(() -> new Exception("User not found on :: " + cmtId));

        repository.delete(like);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", Boolean.TRUE);
        return response;
    }
}
