package com.example.reddit_likes_service.controller;

import com.example.reddit_likes_service.dao.Likesdao;
import com.example.reddit_likes_service.models.Like;
import com.example.reddit_likes_service.models.LikesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/likes/",produces = "application/hal+json")
public class LikesController {

    @Autowired
    private Likesdao repository;

    @PostMapping
    public Like createUser(@RequestBody Like user){
        return repository.save(user);
    }

    @GetMapping("{id}")
    public LikesData getUser(@PathVariable(value = "id") Long post_id){
        List<Like> like = repository.findByPostid(post_id);
        return new LikesData(like);
    }

    @GetMapping
    public List<Like> getAllUsers(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean>  deleteUser(@PathVariable(value = "id") Long likeId) throws Exception{
        Like like = repository.findById(likeId)
                        .orElseThrow(() -> new Exception("User not found on :: " + likeId));

        repository.delete(like);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", Boolean.TRUE);
        return response;
    }
}