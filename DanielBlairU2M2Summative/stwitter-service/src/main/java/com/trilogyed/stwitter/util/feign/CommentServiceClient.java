package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
@RequestMapping("/comments")
public interface CommentServiceClient {

    @GetMapping(value = "/{id}")
    public Comment fetchComment(@PathVariable int id);

    @GetMapping(value = "/post/{post_id}")
    public List<Comment> fetchCommentsByPostId(@PathVariable int post_id);

    @DeleteMapping(value = "/{id}")
    public void deleteComment(@PathVariable int id);
}
