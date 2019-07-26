package com.company.DanielBlairU1M5Summative.dao;

import com.company.DanielBlairU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao.getAllBooks().stream().forEach(b -> bookDao.deleteBook(b.getBook_id()));
        publisherDao.getAllPublishers().stream().forEach(p -> publisherDao.deletePublisher(p.getPublisher_id()));
    }

    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisherDao.createPublisher(publisher);

        assertEquals(publisherDao.getPublisher(publisher.getPublisher_id()), publisher);

        publisherDao.deletePublisher(publisher.getPublisher_id());

        assertNull(publisherDao.getPublisher(publisher.getPublisher_id()));
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisherDao.createPublisher(publisher);

        publisher.setName("Updated Publisher");
        publisher.setStreet("Updated Street");
        publisher.setCity("Updated City");
        publisher.setState("SC");
        publisher.setPostal_code("28270");
        publisher.setPhone("704-907-8191");
        publisher.setEmail("updatedPublisher@publisher.com");

        publisherDao.updatePublisher(publisher);

        assertEquals(publisherDao.getPublisher(publisher.getPublisher_id()), publisher);
    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("NC");
        publisher.setPostal_code("28277");
        publisher.setPhone("704-936-9359");
        publisher.setEmail("publisher@publisher.com");

        publisher = publisherDao.createPublisher(publisher);

        publisher.setName("New Publisher");
        publisher.setStreet("New Street");
        publisher.setCity("New City");
        publisher.setState("SC");
        publisher.setPostal_code("28270");
        publisher.setPhone("704-907-8191");
        publisher.setEmail("newPublisher@publisher.com");

        publisherDao.createPublisher(publisher);

        assertEquals(publisherDao.getAllPublishers().size(), 2);
    }
}
