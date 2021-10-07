package com.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books b JOIN authors a ON b.authorId = a.id", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setBookId(rs.getInt("id"));
            book.setAuthorFirstName(rs.getString("first_name"));
            book.setAuthorLastName(rs.getString("last_name"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return books;
    }
    
}
