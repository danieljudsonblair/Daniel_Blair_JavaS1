package com.company.DanielBlairU1M5Summative.dao;

import com.company.DanielBlairU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {
    Book createBook(Book book);

    Book getBook(Integer book_id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(Integer book_id);

    List<Book> getBooksByAuthor(Integer author_id);
}
