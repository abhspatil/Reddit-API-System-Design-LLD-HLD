package com.reddit.api.controller;

import com.reddit.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/feed/")
public class Newsfeeddata {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{postid}")
    public Feed getFeed(@PathVariable Long postid){
        String cmturl = "http://LIKES-SERVICE/comments/"+postid;
        String likeurl = "http://LIKES-SERVICE/likes/"+postid;
        String posturl = "http://POSTS-SERVICE/posts/"+postid;

        CommentData comments = restTemplate.getForObject(cmturl,CommentData.class);
        LikesData likes =  restTemplate.getForObject(likeurl,LikesData.class);
        Post post = restTemplate.getForObject(posturl,Post.class);

        Feed feed = new Feed(post,comments,likes);

        return feed;
    }
}
