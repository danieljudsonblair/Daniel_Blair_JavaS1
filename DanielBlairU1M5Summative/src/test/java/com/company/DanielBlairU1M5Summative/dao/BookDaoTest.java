package com.company.DanielBlairU1M5Summative.dao;

import com.company.DanielBlairU1M5Summative.model.Author;
import com.company.DanielBlairU1M5Summative.model.Book;
import com.company.DanielBlairU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao.getAllBooks().stream().forEach(b -> bookDao.deleteBook(b.getBook_id()));
        publisherDao.getAllPublishers().stream().forEach(p -> publisherDao.deletePublisher(p.getPublisher_id()));
        authorDao.getAllAuthors().stream().forEach(a -> authorDao.deleteAuthor(a.getAuthor_id()));
    }

    @Test
    public void addGetDeleteBook() {

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

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisherDao.createPublisher(publisher);

        Book book = new Book();
        book.setIsbn("isbn");
        book.setPublish_date(LocalDate.of(2019, 1, 5));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Book Title");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        bookDao.createBook(book);

        assertEquals(bookDao.getBook(book.getBook_id()), book);

        bookDao.deleteBook(book.getBook_id());

        assertNull(bookDao.getBook(book.getBook_id()));
    }

    @Test
    public void updateBook() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisherDao.createPublisher(publisher);

        Book book = new Book();
        book.setIsbn("isbn");
        book.setPublish_date(LocalDate.of(2019, 1, 5));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Book Title");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        bookDao.createBook(book);

        book.setIsbn("updated isbn");
        book.setPublish_date(LocalDate.of(2018, 2,6));
        book.setTitle("Updated Book Title");
        book.setPrice(new BigDecimal("18.99"));

        bookDao.updateBook(book);

        assertEquals(bookDao.getBook(book.getBook_id()), book);
    }

    @Test
    public void getAllBooks() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisherDao.createPublisher(publisher);

        Book book = new Book();
        book.setIsbn("isbn");
        book.setPublish_date(LocalDate.of(2019, 1, 5));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Book Title");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        bookDao.createBook(book);

        book.setIsbn("isbn 2");
        book.setPublish_date(LocalDate.of(2018, 2,6));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Book Title 2");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("18.99"));

        bookDao.createBook(book);

        assertEquals(bookDao.getAllBooks().size(), 2);
    }

    @Test
    public void getBooksByAuthor() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisherDao.createPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("First");
        author.setLast_name("Last");
        author.setStreet("Street");
        author.setCity("City");
        author.setState("SC");
        author.setPostal_code("28277");
        author.setPhone("704-936-9359");
        author.setEmail("author@author.com");

        author = authorDao.createAuthor(author);

        Book book = new Book();
        book.setIsbn("isbn");
        book.setPublish_date(LocalDate.of(2019, 1, 5));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Book Title");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        bookDao.createBook(book);

        author.setFirst_name("First1");
        author.setLast_name("Last1");
        author.setStreet("Street1");
        author.setCity("City1");
        author.setState("NC");
        author.setPostal_code("28270");
        author.setPhone("704-936-9359");
        author.setEmail("author1@author.com");

        authorDao.createAuthor(author);

        book.setIsbn("isbn 2");
        book.setPublish_date(LocalDate.of(2018, 2,6));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Book Title 2");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("18.99"));

        bookDao.createBook(book);

        assertEquals(bookDao.getBooksByAuthor(author.getAuthor_id()).size(), 1);

        assertEquals(bookDao.getAllBooks().size(), 2);
    }
}
