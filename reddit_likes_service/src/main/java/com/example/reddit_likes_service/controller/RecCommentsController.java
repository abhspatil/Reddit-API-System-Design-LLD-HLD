package com.example.reddit_likes_service.controller;

import com.example.reddit_likes_service.dao.CommentsRecdao;
import com.example.reddit_likes_service.dao.RecCommentsdao;
import com.example.reddit_likes_service.models.Comment;
import com.example.reddit_likes_service.models.CommentRecReply;
import com.example.reddit_likes_service.models.CommentsReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping(value = "/reccomments/",produces = "application/hal+json")
public class RecCommentsController {

    @Autowired
    private RecCommentsdao replyrepo;

    @Autowired
    private CommentsRecdao commentsrepo;

    @PostMapping
    public Comment create(@RequestBody Comment comment){
       return commentsrepo.save(comment);
    }

    @GetMapping
    public List<Comment> getAll(){
        return commentsrepo.findAll();
    }

    @PostMapping("{cmtId}")
    public CommentsReply create(@PathVariable Long cmtId, @RequestBody Comment comment){
        comment.setCreated_at(new Date());
        commentsrepo.save(comment);

        CommentsReply commentsReply = new CommentsReply(cmtId,comment.getId());
        replyrepo.save(commentsReply);

        return commentsReply;
    }

    @GetMapping("{id}")
    public List<CommentRecReply> get(@PathVariable(value = "id") Long post_id){
        List<Comment> commentList = commentsrepo.findAllByPostid(post_id);

        Map<Long,Comment> hm = new HashMap<>();

        for(Comment comment :  commentList){
            hm.put(comment.getId(),comment);
        }

        return CommentDfs(commentList,hm);
    }

    public  List<CommentRecReply> CommentDfs(List<Comment> commentList,Map<Long,Comment> hm){

        Map<Long,CommentRecReply> replyMap = new HashMap<>();
        Stack<Comment> stack = new Stack<>();
        Set<Long> visited = new HashSet<>();

        stack.push(commentList.get(0));

        while (!stack.empty()){
            Comment comment = stack.pop();
            visited.add(comment.getId());

            List<CommentsReply> commentsReplies = replyrepo.findByCommentId(comment.getId());

            for(CommentsReply commentsReply : commentsReplies){
                if(replyMap.containsKey(commentsReply.getCommentId())){
                    replyMap.get(commentsReply).setCommentRecReplies(hm.get(commentsReply.getCommentId()));
                }else {
                    CommentRecReply commentRecReply = new CommentRecReply(hm.get(commentsReply.getCommentId()));
                    replyMap.put(commentsReply.getCommentId(),commentRecReply);
                }

                if(!visited.contains(commentsReply.getCommentId())){
                    stack.push(hm.get(commentsReply.getCommentId()));
                    visited.add(commentsReply.getCommentId());
                }
            }
        }

        List<CommentRecReply> list = new ArrayList<>(replyMap.values());

        return list;

    }

}
