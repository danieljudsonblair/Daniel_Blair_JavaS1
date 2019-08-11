package com.trilogyed.stwitter.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postID;
    @NotNull(message = "You must supply a postDate in format YYYY-MM-DD")
    private LocalDate postDate;
    @NotNull(message = "You must supply a posterName")
    @NotEmpty(message = "posterName must not be empty")
    private String posterName;
    @NotNull(message = "You must supply a post")
    @NotEmpty(message = "post must not be empty")
    private String post;

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return getPostID() == post1.getPostID() &&
                getPostDate().equals(post1.getPostDate()) &&
                getPosterName().equals(post1.getPosterName()) &&
                getPost().equals(post1.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostID(), getPostDate(), getPosterName(), getPost());
    }
}
