package com.example.reddit_post_service.controller;

import com.example.reddit_post_service.dao.PostRepository;
import com.example.reddit_post_service.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "/posts/",produces = "application/hal+json")
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping("{post_id}")
    public Optional<Post> getPost(@PathVariable Long post_id){
        return repository.findById(post_id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        post.setCreated_at(new Date());
        return repository.save(post);
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return  repository.findAll();
    }

    @PutMapping("{post_id}")
    public Post updatePost(@PathVariable Long post_id, @RequestBody Post updated_post){

        Post post = repository.findById(post_id).orElse(null);

        if(post != null){
            post.setCreated_at(new Date());
            post.setDescription((updated_post.getDescription()));
            post.setTitle(updated_post.getTitle());

            repository.save(post);

        }else{
            repository.save(updated_post);
        }

        return updated_post;
    }

    @DeleteMapping("{post_id}")
    public Map<String,Boolean> deletePost(@PathVariable Long post_id) throws Exception{

        Post posts = repository.findById(post_id)
                .orElseThrow(() -> new Exception("Post not Found :: "+post_id));

        repository.delete(posts);
        Map<String,Boolean> response = new HashMap<>();
        response.put("status",Boolean.TRUE);
        return response;
    }

}
