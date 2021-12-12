package com.example.controllers;

import com.example.entity.book.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestApi {

    private final BookService bookService;

    @Autowired
    public BookRestApi(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/books/by-author")
    public ResponseEntity<List<Book>> booksByAuthor(@RequestParam("author") String authorName) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(authorName));
    }

    @GetMapping("/books/by-title")
    public ResponseEntity<List<Book>> booksByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    public ResponseEntity<List<Book>> priceRangeBooks(@RequestParam("min") Double min, @RequestParam("max") Double max) {
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min, max));
    }

    @GetMapping("/books/with-max-price")
    public ResponseEntity<List<Book>> maxPriceBooks() {
        return ResponseEntity.ok(bookService.getBooksWithMaxPrice());
    }

    @GetMapping("/book/bestsellers")
    public ResponseEntity<List<Book>> bestSellerBooks() {
        return ResponseEntity.ok(bookService.getBestsellers());
    }
}
