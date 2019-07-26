package com.company.DanielBlairU1M5Summative.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private Integer book_id;
    private String isbn;
    private LocalDate publish_date;
    private Integer author_id;
    private String title;
    private Integer publisher_id;
    private BigDecimal price;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBook_id().equals(book.getBook_id()) &&
                getIsbn().equals(book.getIsbn()) &&
                getPublish_date().equals(book.getPublish_date()) &&
                getAuthor_id().equals(book.getAuthor_id()) &&
                getTitle().equals(book.getTitle()) &&
                getPublisher_id().equals(book.getPublisher_id()) &&
                getPrice().equals(book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook_id(), getIsbn(), getPublish_date(), getAuthor_id(), getTitle(), getPublisher_id(), getPrice());
    }
}
