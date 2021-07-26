package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.repository.BookRepository;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;
    private BookRepository repository;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        if (!book.getAuthor().isEmpty() || !book.getTitle().isEmpty() || book.getSize() != null) {
            bookService.saveBook(book);
            logger.info("current repository size: " + bookService.getAllBooks().size());
        } else {
            logger.info("got an empty fields");
        }
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBook(@NonNull Integer bookIdToRemove) {
        if (bookService.removeBookById(bookIdToRemove)) {
            logger.info("Book removed " + bookIdToRemove);
        } else {
            logger.info("Wrong id " + bookIdToRemove);
        }
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove_all_by_author")
    public String removeAllBooksByAuthor(@NonNull String author) {
        for (Book book : bookService.getAllBooks()) {
            if (author.equals(book.getAuthor())) {
                if (bookService.removeAllBooksByAuthor(author)) {
                    logger.info("Book removed " + author);
                } else {
                    logger.info("Wrong id " + author);
                }
            }
        }
        return "redirect:/books/shelf";
    }


    @PostMapping("/remove_all_by_title")
    public String removeAllByTitle(@NonNull String title) {
        for (Book book : bookService.getAllBooks()) {
            if (title.equals(book.getTitle())) {
                if (bookService.removeAllByTitle(title)) {
                    logger.info("Book removed " + title);
                } else {
                    logger.info("Wrong id " + title);
                }
            }
        }
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove_all_by_size")
    public String removeAllBySize(@NonNull Integer pages) {
        for (Book book : bookService.getAllBooks()) {
            if (pages.equals(book.getSize())) {
                if (bookService.removeAllBySize(pages)) {
                    logger.info("Book removed " + pages);
                } else {
                    logger.info("Wrong id " + pages);
                }
            }
        }
        return "redirect:/books/shelf";
    }

    @GetMapping("/book_list")
    public String findBooksByAuthor(String author) {
        bookService.findBooksByAuthor(author);
        return "book_shelf";
    }
}