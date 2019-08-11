package com.trilogyed.stwitter.viewModel;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;

import java.util.List;
import java.util.Objects;

public class PostViewModel extends Post {

    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PostViewModel that = (PostViewModel) o;
        return getCommentList().equals(that.getCommentList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCommentList());
    }
}
