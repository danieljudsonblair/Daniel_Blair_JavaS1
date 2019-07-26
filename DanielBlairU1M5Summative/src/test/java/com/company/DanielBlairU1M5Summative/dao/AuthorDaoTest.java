package com.company.DanielBlairU1M5Summative.dao;

import com.company.DanielBlairU1M5Summative.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao.getAllBooks().stream().forEach(b -> bookDao.deleteBook(b.getBook_id()));
        authorDao.getAllAuthors().stream().forEach(a -> authorDao.deleteAuthor(a.getAuthor_id()));
    }

    @Test
    public void addGetDeleteAuthor() {
        Author author = new Author();
        author.setFirst_name("First");
        author.setLast_name("Last");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("SC");
        author.setPostal_code("28277");
        author.setPhone("704-936-9359");
        author.setEmail("author@author.com");

        authorDao.createAuthor(author);

        assertEquals(authorDao.getAuthor(author.getAuthor_id()), author);

        authorDao.deleteAuthor(author.getAuthor_id());

        assertNull(authorDao.getAuthor(author.getAuthor_id()));
    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirst_name("First");
        author.setLast_name("Last");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("SC");
        author.setPostal_code("28277");
        author.setPhone("704-936-9359");
        author.setEmail("author@author.com");

        authorDao.createAuthor(author);

        author.setFirst_name("Updated First");
        author.setLast_name("Updated Last");
        author.setStreet("Updated Street");
        author.setCity("Updated City");
        author.setState("NC");
        author.setPostal_code("28270");
        author.setPhone("704-907-8191");
        author.setEmail("updatedAuthor@author.com");

        authorDao.updateAuthor(author);

        assertEquals(authorDao.getAuthor(author.getAuthor_id()), author);
    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();
        author.setFirst_name("First");
        author.setLast_name("Last");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("SC");
        author.setPostal_code("28277");
        author.setPhone("704-936-9359");
        author.setEmail("author@author.com");

        authorDao.createAuthor(author);

        author.setFirst_name("New First");
        author.setLast_name("New Last");
        author.setStreet("New Street");
        author.setCity("New City");
        author.setState("NC");
        author.setPostal_code("28270");
        author.setPhone("704-907-8191");
        author.setEmail("newAuthor@author.com");

        authorDao.createAuthor(author);

        assertEquals(authorDao.getAllAuthors().size(), 2);
    }
}
