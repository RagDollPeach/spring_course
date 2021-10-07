package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchPage {

    @GetMapping("/search")
    public String searchPage() {
        return "/search/index";
    }
}
