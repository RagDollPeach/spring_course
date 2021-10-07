package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop/genres")
public class DetectivePage {

    @GetMapping("/detective")
    public String detectivePage() {
        return "/genres/detective";
    }
}
