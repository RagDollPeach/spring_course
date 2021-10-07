package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpPage {

    @GetMapping("/help")
    public String helpPage() {
        return "faq";
    }
}
