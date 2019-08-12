package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    CommentProducer producer;
    CommentServiceClient commentClient;
    PostServiceClient postClient;

    @Autowired
    public ServiceLayer(CommentProducer producer, CommentServiceClient commentClient, PostServiceClient postClient) {
        this.producer = producer;
        this.commentClient = commentClient;
        this.postClient = postClient;
    }

    private String noItem(String item, int id) {
        return "No " + item + " exists @ ID " + id;
    }

    private String noProperty(String property) { return "You must supply a value for property: " + property; }

    private String nonEmptyProperty(String property) { return "You must supply a non-empty value for " + property; }

    public Post savePost(Post post) {

        post.setPostID(postClient.createPost(post).getPostID());

        return post;
    }

    public String saveComment(Comment comment) {
        if (postClient.fetchPost(comment.getPostId()) == null)
            throw new IllegalArgumentException("Post ID in path must match an existing post");
        return producer.createComment(comment);
    }

    public PostViewModel fetchPost(int id) {
        if (postClient.fetchPost(id) == null)
            throw new NotFoundException(noItem("post", id));

        return postViewModelHelper(postClient.fetchPost(id));
    }

    public List<PostViewModel> fetchPostsByPosterName(String poster_name) {
        if (postClient.fetchPostByPosterName(poster_name).size() == 0)
            throw new NotFoundException(poster_name + " has not made any posts");
        List<PostViewModel> pvmList = new ArrayList<>();
        postClient.fetchPostByPosterName(poster_name).stream().forEach(post -> pvmList.add(postViewModelHelper(post)));

        return pvmList;
    }

    public void updatePost(PostViewModel pvm) {
        if (pvm.getPost() == null)
            throw new IllegalArgumentException(noProperty("post"));
        if (pvm.getPost() != null && pvm.getPost().equals(""))
            throw new IllegalArgumentException(nonEmptyProperty("post"));
        if (postClient.fetchPost(pvm.getPostID()) == null)
            throw new NotFoundException(noItem("post", pvm.getPostID()));
        Post up = postClient.fetchPost(pvm.getPostID());
        if (pvm.getPost() != null)
            up.setPost(pvm.getPost());

        postClient.updatePost(up);
    }

    public void updateComment(Comment comment) {
        if (comment.getComment() == null)
            throw new IllegalArgumentException(noProperty("comment"));
        if (comment.getComment() != null && comment.getComment().equals(""))
            throw new IllegalArgumentException(nonEmptyProperty("comment"));
        if (commentClient.fetchComment(comment.getCommentId()) == null)
            throw new NotFoundException(noItem("comment", comment.getCommentId()));
        Comment uc = commentClient.fetchComment(comment.getCommentId());
        if (comment.getComment() != null)
            uc.setComment(comment.getComment());

        producer.updateComment(uc);
    }

    public void removePost(int id) {
        if (postClient.fetchPost(id) == null)
            throw new NotFoundException(noItem("post", id));

        commentClient.fetchCommentsByPostId(id).stream().forEach(comment -> commentClient.deleteComment(comment.getCommentId()));
        postClient.deletePost(id);
    }

    public void removeComment(int id) {
        if (commentClient.fetchComment(id) == null)
            throw new NotFoundException(noItem("comment", id));

        commentClient.deleteComment(id);
    }

    private PostViewModel postViewModelHelper(Post post) {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostID(post.getPostID());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setPost(post.getPost());
        pvm.setCommentList(commentClient.fetchCommentsByPostId(post.getPostID()));

        return pvm;
    }
}
