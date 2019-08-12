package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {

    @GetMapping(value = "/posts/{id}")
    public PostViewModel fetchPost(@PathVariable int id);

    @GetMapping(value = "/posts/user/{poster_name}")
    public List<Post> fetchPostByPosterName(@PathVariable String poster_name);

    @PostMapping(value = "/posts")
    public Post createPost(@RequestBody Post post);

    @PutMapping(value = "/posts/{id}")
    public void updatePost(@RequestBody Post post);

    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable int id);
}
