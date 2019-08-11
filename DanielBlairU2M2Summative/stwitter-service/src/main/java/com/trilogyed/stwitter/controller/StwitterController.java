package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/posts")
public class StwitterController {

    @Autowired
    ServiceLayer service;

    @Autowired
    CommentServiceClient commentClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody @Valid Post post) {
        return service.savePost(post);
    }

    @GetMapping(value = "/post/{id}")
    public PostViewModel getPost(@PathVariable int id) {
        return service.fetchPost(id);
    }

    @GetMapping(value = "/user/{poster_name}")
    public List<PostViewModel> getPostsByPosterName(@PathVariable String poster_name) {
        return service.fetchPostsByPosterName(poster_name);
    }

    @PostMapping(value = "/comments/post/{post_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable int post_id, @RequestBody @Valid Comment comment) {
        if (service.fetchPost(post_id) == null)
            throw new IllegalArgumentException("Post ID in path must match an existing post");
        comment.setPostId(post_id);
        service.saveComment(comment);
    }

    @PutMapping(value = "/post/{post_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int post_id, @RequestBody PostViewModel pvm) {
        pvm.setPostID(post_id);
        service.updatePost(pvm);
    }

    @PutMapping(value = "/post/comment/{comment_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int comment_id, @RequestBody Comment comment) {
        comment.setCommentId(comment_id);
        service.updateComment(comment);
    }

    @DeleteMapping(value = "/post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        service.removePost(id);
    }

    @DeleteMapping(value = "/post/comment/{comment_id}")
    public void deleteComment(@PathVariable int comment_id) {
        service.removeComment(comment_id);
    }
}
