package com.example.controllers;

import com.example.struct.author.Author;
import com.example.data.AuthorService;
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

    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }
}
