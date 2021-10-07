package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartPage {

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }
}
