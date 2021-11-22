package com.example.entity.book.links;

import com.example.entity.author.Author;
import com.example.entity.book.Book;

import javax.persistence.*;

@Entity
@Table(name = "book2author")
public class Book2AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "author_id")
    private Integer authorId;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Book book;

    @Column(name = "sort_index",columnDefinition = "INT NOT NULL  DEFAULT 0")
    private int sortIndex;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}
