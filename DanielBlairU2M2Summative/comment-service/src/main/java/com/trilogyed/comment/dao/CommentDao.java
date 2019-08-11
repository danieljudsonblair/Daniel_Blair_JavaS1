package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {
    public Comment get(int id);
    public List<Comment> getAll();
    public List<Comment> getByPostId(int post_id);
    public Comment add(Comment comment);
    public void update(Comment comment);
    public void delete(int id);
}
