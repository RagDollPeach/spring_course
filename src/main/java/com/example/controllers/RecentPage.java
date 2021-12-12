package com.example.controllers;

import com.example.entity.book.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RecentPage {

    private final BookService bookService;

    @Autowired
    public RecentPage(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return bookService.getBooksByDate(LocalDate.ofYearDay(2020,1),LocalDate.now());
    }

    @GetMapping("/recent")
    public String recentPage() {
        return "/books/recent";
    }
}
