package com.example.data;

import com.example.entity.book.Book;

import java.util.List;

public class RecommendedBooksPageDTO {

    private Integer count;
    private List<Book> books;

    public RecommendedBooksPageDTO(List<Book> books) {
        this.books = books;
        this.count = books.size();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
