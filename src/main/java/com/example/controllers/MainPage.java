package com.example.controllers;

import com.example.service.BookService;
import com.example.entity.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainPage {

    private final BookService bookService;

    @Autowired
    public MainPage( BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getBooksData();
    }

    @ModelAttribute("newBooks")
    public List<Book> newBooks() {
        return bookService.getBooksByDate(LocalDate.ofYearDay(2020,1),LocalDate.now());
    }

    @ModelAttribute("bestsellers")
    public List<Book> bestsellers() {
        return bookService.getBestsellers();
    }

        @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
