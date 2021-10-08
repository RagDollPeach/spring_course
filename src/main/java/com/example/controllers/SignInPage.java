package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInPage {

    @GetMapping("/signin")
    public String signInPage() {
        return "signin";
    }
}
