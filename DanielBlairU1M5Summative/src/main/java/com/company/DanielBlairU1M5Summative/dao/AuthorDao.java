package com.company.DanielBlairU1M5Summative.dao;

import com.company.DanielBlairU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {
    Author createAuthor(Author author);

    Author getAuthor(Integer author_id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(Integer author_id);
}
