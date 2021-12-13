package com.example.controllers;

import com.example.data.RecommendedBooksPageDTO;
import com.example.service.BookService;
import com.example.entity.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return bookService.getPageOfRecommendedBooks(0,6).getContent();
    }

    @ModelAttribute("newBooks")
    public List<Book> newBooks() {
        return bookService.getBooksByDate(LocalDate.now().minusYears(1),LocalDate.now());
    }

    @ModelAttribute("bestsellers")
    public List<Book> bestsellers() {
        return bookService.getBestsellers();
    }

        @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public RecommendedBooksPageDTO getBookPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return new RecommendedBooksPageDTO(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
    }
}
