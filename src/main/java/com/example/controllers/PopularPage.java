package com.example.controllers;

import com.example.struct.book.Book;
import com.example.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class PopularPage {

    private final BookService bookService;

    @Autowired
    public PopularPage(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("popBooksList")
    public List<Book> bookList(){
        return bookService.getBooksData();
    }

    @GetMapping("/popular")
    public String popularPage() {
        return "/books/popular";
    }
}
