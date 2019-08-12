package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceLayerTests {

    ServiceLayer service;
    CommentProducer producer;
    CommentServiceClient commentClient;
    PostServiceClient postClient;

    @Before
    public void setUp() throws Exception {

        setUpCommentProducerMock();
        setUpCommentServiceClientMock();
        setUpPostServiceClientMock();

        service = new ServiceLayer(producer, commentClient, postClient);
    }

    public void setUpCommentProducerMock() {
        producer = mock(CommentProducer.class);

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 01, 01));
        comment.setCommenterName("name");
        comment.setComment("comment");

        doReturn(CommentProducer.SAVE_QUEUED_MSG).when(producer).createComment(comment);
        doReturn(CommentProducer.UPDATE_QUEUED_MSG).when(producer).updateComment(comment);
    }

    public void setUpCommentServiceClientMock() {
        commentClient = mock(CommentServiceClient.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 01, 01));
        comment.setCommenterName("name");
        comment.setComment("comment");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(comment).when(commentClient).fetchComment(1);
        doReturn(commentList).when(commentClient).fetchCommentsByPostId(1);
        doNothing().when(commentClient).deleteComment(1);
    }

    public void setUpPostServiceClientMock() {
        postClient = mock(PostServiceClient.class);

        PostViewModel post = new PostViewModel();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019, 01, 01));
        post.setPosterName("name");
        post.setPost("post");
        post.setCommentList(new ArrayList<>());

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 01, 01));
        post1.setPosterName("name");
        post1.setPost("post");

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(postClient).fetchPost(1);
        doReturn(postList).when(postClient).fetchPostByPosterName("name");
        doReturn(post).when(postClient).createPost(post1);
        doNothing().when(postClient).updatePost(post);
        doNothing().when(postClient).deletePost(1);
    }

    @Test
    public void saveFetchFetchByPosterName() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 01, 01));
        post.setPosterName("name");
        post.setPost("post");

        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostDate(LocalDate.of(2019, 01, 01));
        post1.setPosterName("name");
        post1.setPost("post");

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 01, 01));
        comment.setCommenterName("name");
        comment.setComment("comment");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        PostViewModel pvm = new PostViewModel();
        pvm.setPostID(1);
        pvm.setPostDate(LocalDate.of(2019, 01, 01));
        pvm.setPosterName("name");
        pvm.setPost("post");
        pvm.setCommentList(commentList);

        List<Post> postList = new ArrayList<>();
        postList.add(pvm);

        assertEquals(service.savePost(post), post1);
        assertEquals(service.fetchPost(1), pvm);
        assertEquals(service.fetchPostsByPosterName("name"), postList);
    }

    @Test
    public void saveComment() {
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 01, 01));
        comment.setCommenterName("name");
        comment.setComment("comment");

        assertEquals(service.saveComment(comment), producer.SAVE_QUEUED_MSG);
    }

    @Test
    public void updatePost() {
        PostViewModel pvm = new PostViewModel();
        pvm.setPost("updated post");
        pvm.setPostID(1);

        service.updatePost(pvm);

        ArgumentCaptor<PostViewModel> pvmCaptor = ArgumentCaptor.forClass(PostViewModel.class);
        verify(postClient).updatePost(pvmCaptor.capture());
        assertEquals(pvm.getPost(), pvmCaptor.getValue().getPost());
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setComment("updated comment");
        comment.setCommentId(1);

        service.updateComment(comment);

        ArgumentCaptor<Comment> commentCaptor = ArgumentCaptor.forClass(Comment.class);
        verify(producer).updateComment(commentCaptor.capture());
        assertEquals(comment.getComment(), commentCaptor.getValue().getComment());
    }

    @Test
    public void deletePost() {
        Post post = new Post();
        post.setPostID(1);

        service.removePost(post.getPostID());

        ArgumentCaptor<Integer> postCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(postClient).deletePost(postCaptor.capture());
        assertEquals(post.getPostID(), postCaptor.getValue().intValue());
    }

    @Test
    public void deleteComment() {
        Comment comment = new Comment();
        comment.setCommentId(1);

        service.removeComment(comment.getCommentId());

        ArgumentCaptor<Integer> commentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(commentClient).deleteComment(commentCaptor.capture());
        assertEquals(comment.getCommentId(), commentCaptor.getValue().intValue());
    }
}
