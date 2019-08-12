package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @GetMapping(value = "/comments/{comment_id}")
    public Comment fetchComment(@PathVariable int comment_id);

    @GetMapping(value = "/comments/post/{post_id}")
    public List<Comment> fetchCommentsByPostId(@PathVariable int post_id);

    @DeleteMapping(value = "/comments/{comment_id}")
    public void deleteComment(@PathVariable int comment_id);
}
