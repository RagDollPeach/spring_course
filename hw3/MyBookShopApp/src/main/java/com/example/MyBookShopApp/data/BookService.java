package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.AutoPopulatingList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT b.id , b.title, b.priceOld, b. price, a.name as author FROM books b " +
                "JOIN authors a ON b.authorId = a.id", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setBookId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return books;
    }

    public List<Author> getAuthors() {
        return jdbcTemplate.query("SELECT name FROM authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setName(rs.getString("name"));
            return author;
        });
    }

    public List<AuthorSection> inLineAuthors() {
        Map<String, List<Author>> inLineAuthors = getAuthors().stream().collect(Collectors.groupingBy(author -> author.getName().substring(0,1)));
        List<AuthorSection> authorSections = new ArrayList<>();
        for (Map.Entry<String, List<Author>> map: inLineAuthors.entrySet()) {
            authorSections.add(new AuthorSection(map.getKey(),map.getValue()));
        }
        return authorSections;
    }
}
