package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {
    public Post add(Post post);
    public Post get(int id);
    public List<Post> getAll();
    public List<Post> getByPosterName(String poster_name);
    public void update(Post post);
    public void delete(int post_id);
}
