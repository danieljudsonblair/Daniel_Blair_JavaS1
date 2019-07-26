package com.company.DanielBlairU1M5Summative.dao;

import com.company.DanielBlairU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher createPublisher(Publisher publisher);

    Publisher getPublisher(Integer publisher_id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(Integer publisher_id);
}
