package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "comment-service")
@RequestMapping("/comments")
public interface CommentClient {

    @PostMapping
    public Comment createComment(Comment comment);
    @PutMapping(value = "/{id}")
    public void updateComment(@PathVariable int id, @RequestBody Comment comment);
}
