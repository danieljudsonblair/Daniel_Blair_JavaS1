package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CacheConfig(cacheNames = {"posts"})
public class PostController {

    @Autowired
    PostDao dao;

    @CachePut(key = "#result.getPostID()")
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return dao.add(post);
    }

    @Cacheable
    @GetMapping(value = "/{id}")
    public Post getPost(@PathVariable int id) {
        return dao.get(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return dao.getAll();
    }

    @GetMapping(value = "/user/{poster_name}")
    public List<Post> getPostsByPosterName(@PathVariable String poster_name) {
        return dao.getByPosterName(poster_name);
    }

    @CacheEvict(key = "#post.getPostID()")
    @PutMapping(value = "/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        post.setPostID(id);
        dao.update(post);
    }

    @CacheEvict
    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable int id) {
        dao.delete(id);
    }
}
