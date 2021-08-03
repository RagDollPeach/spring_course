package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.example.web.dto.BookIdToRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/books")
@Scope("singleton")
public class BookShelfController {

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info(this.toString());
        model.addAttribute("book", new Book());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", book);
            model.addAttribute("bookIdToRemove", new BookIdToRemove());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        } else {
            if (!book.getAuthor().isEmpty() || !book.getTitle().isEmpty() || book.getSize() != null) {
                bookService.saveBook(book);
                logger.info("current repository size: " + bookService.getAllBooks().size());
            } else {
                logger.info("got an empty fields");
            }
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/remove")
    public String removeBook(@Valid BookIdToRemove bookIdToRemove, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        } else {
            bookService.removeBookById(bookIdToRemove.getId());
            return "redirect:/books/shelf";
        }
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
    public String removeAllBySize(@NonNull String pages) {
        for (Book book : bookService.getAllBooks()) {
            if (pages.equals(String.valueOf(book.getSize()))) {
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
    public String findBooksByAuthor(Model model, @NonNull String author) {
        List<Book> list = bookService.findBooksByAuthor(author);
        model.addAttribute("book", new Book());
        model.addAttribute("authors", list);
        logger.info("find books " + list);
        return "redirect:/books/shelf";
    }
}