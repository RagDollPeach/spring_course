package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostponedPage {

    @GetMapping("/postponed")
    public String postponedPage() {
        return "postponed";
    }
}
