package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentsPage {

    @GetMapping("/documents")
    public String documentsPage() {
        return "/documents/index";
    }
}
