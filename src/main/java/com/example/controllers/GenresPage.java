package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenresPage {

    @GetMapping("/genres")
    public String genresPage() {
        return "/genres/index";
    }
}
