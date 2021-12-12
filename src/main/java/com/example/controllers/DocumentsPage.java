package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentsPage {

    @GetMapping("/documents")
    public String documentsPage() {
        return "/documents/index";
    }

    @GetMapping("/documents/slug")
    public String slugPage() {
        return "/documents/slug";
    }
}
