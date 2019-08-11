package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao {

    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_POST =
            "insert into post (post_date, poster_name, post) values (?, ?, ?)";
    public static final String SELECT_POST_BY_ID =
            "select * from post where post_id = ?";
    public static final String SELECT_POSTS_BY_POSTER_NAME =
            "select * from post where poster_name = ?";
    public static final String SELECT_ALL_POSTS =
            "select * from post";
    public static final String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";
    public static final String DELETE_POST =
            "delete from post where post_id = ?";

    @Autowired
    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post add(Post post) {
        jdbcTemplate.update(
                INSERT_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost()
                );

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        post.setPostID(id);

        return post;
    }

    @Override
    public Post get(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST_BY_ID, this::mapRowToPost, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query(SELECT_ALL_POSTS, this::mapRowToPost);
    }

    @Override
    public List<Post> getByPosterName(String poster_name) {
        return jdbcTemplate.query(SELECT_POSTS_BY_POSTER_NAME, this::mapRowToPost, poster_name);
    }

    @Override
    public void update(Post post) {
        jdbcTemplate.update(
                UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostID()
        );
    }

    @Override
    public void delete(int post_id) {
        jdbcTemplate.update(DELETE_POST, post_id);
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostID(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}
