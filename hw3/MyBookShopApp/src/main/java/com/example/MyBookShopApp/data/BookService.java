package com.example.MyBookShopApp.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getNames() {
        String htmlFile = parseFile();
        List<String> list = new ArrayList<>();
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.getElementsByTag("a");

        for (Element element : elements) {
            Pattern pattern = Pattern.compile(".{2,}\\s[А-Я].+");
            Matcher matcher = pattern.matcher(element.text());
            while (matcher.find()) {
                list.add(matcher.group());
            }
        }
        return list;
    }

    private String parseFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> list = Files.readAllLines(
                    Paths.get("D:\\Spring\\hw3\\MyBookShopApp\\src\\main\\resources\\templates\\authors.html"));
            list.forEach(s -> builder.append(s).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
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
}
