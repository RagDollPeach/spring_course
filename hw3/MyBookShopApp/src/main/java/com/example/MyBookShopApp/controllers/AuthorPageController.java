package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class AuthorPageController {

    private final BookService bookService;

    @Autowired
    public AuthorPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authors", bookService.getAuthors());
        return "authors";
    }
}
