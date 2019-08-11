package com.trilogyed.post.dao;


import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoJdbcTemplateImplTests {

    @Autowired
    PostDao dao;

    @Before
    public void setUp() throws Exception {
        dao.getAll().stream().forEach(p -> dao.delete(p.getPostID()));
    }

    @Test
    public void addGetGetAllGetByPosterNameDelete() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 8, 2));
        post.setPosterName("Name");
        post.setPost("Post");

        assertEquals(dao.getAll().size(), 0);
        assertEquals(dao.getByPosterName("danimal").size(), 0);
        assertNull(dao.get(1));

        dao.add(post);

        assertEquals(dao.get(post.getPostID()), post);

        assertEquals(dao.getAll().size(), 1);

        assertEquals(dao.getByPosterName("Name").size(), 1);

        dao.delete(post.getPostID());

        assertNull(dao.get(post.getPostID()));
    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019,2,2));
        post.setPosterName("Name");
        post.setPost("post your mother");

        dao.add(post);

        post.setPostDate(LocalDate.of(2019,1,1));
        post.setPosterName("updated Name");
        post.setPost("update post your mother");

        dao.update(post);

        assertEquals(dao.get(post.getPostID()), post);
    }
}
