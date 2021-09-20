package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.AuthorSection;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class AuthorPageController {

    private final AuthorSection authorSection;

    @Autowired
    public AuthorPageController( AuthorSection authorSection) {
        this.authorSection = authorSection;
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authors", authorSection.authorsMap());
        return "authors";
    }
}
