package com.example.controllers;

import com.example.entity.author.Author;
import com.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;


@Controller
public class AuthorPage {

    private final AuthorService authorService;

    @Autowired
    public AuthorPage(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        return authorService.getAuthorsMap(); 
    }

    @ModelAttribute("allAuthors")
    public List<Author> gatAllAuthors() {
        return authorService.gatAllAuthors();
    }

    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }

    @GetMapping("/authors/slug")
    public String slugPage() {
        return "/authors/slug";
    }
}
