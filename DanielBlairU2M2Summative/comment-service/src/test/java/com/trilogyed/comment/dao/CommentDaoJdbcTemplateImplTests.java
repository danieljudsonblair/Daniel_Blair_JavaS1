package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
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
public class CommentDaoJdbcTemplateImplTests {

    @Autowired
    CommentDao dao;

    @Before
    public void setUp() throws Exception {
        dao.getAll().stream().forEach(c -> dao.delete(c.getCommentId()));
    }

    @Test
    public void addGetGetAllGetByPostDelete() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 2));
        comment.setCommenterName("Name");
        comment.setComment("Comment");

        assertEquals(dao.getAll().size(), 0);
        assertEquals(dao.getByPostId(1).size(), 0);
        assertNull(dao.get(1));

        dao.add(comment);

        assertEquals(dao.get(comment.getCommentId()), comment);

        assertEquals(dao.getAll().size(), 1);

        assertEquals(dao.getByPostId(1).size(), 1);

        dao.delete(comment.getCommentId());

        assertNull(dao.get(comment.getCommentId()));

        assertEquals(dao.getAll().size(), 0);
        assertEquals(dao.getByPostId(1).size(), 0);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,2,2));
        comment.setCommenterName("Name");
        comment.setComment("comment");

        dao.add(comment);

        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2018,2,2));
        comment.setCommenterName("Updated Name");
        comment.setComment("update comment");

        dao.update(comment);

        assertEquals(dao.get(comment.getCommentId()), comment);
    }
}
