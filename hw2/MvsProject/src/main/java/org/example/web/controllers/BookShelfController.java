package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.exeptions.BookShelfLoginException;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {

    private static final Logger logger = Logger.getLogger(BookShelfController.class);
    private final BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        updateModelForShelf(model);
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors("author") ||
                bindingResult.hasFieldErrors("title") ||
                bindingResult.hasFieldErrors("size")) {
            updateModelForSave(model, book);
            return "book_shelf";
        } else {
            if (bookService.hasAllValuesEmpty(book)) {
                logger.info("book has all values empty :( ");
            } else {
                bookService.saveBook(book);
                logger.info("current repository size: " + bookService.getAllBooks().size());
            }
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/remove")
    public String removeBook(@Valid Book book, BindingResult bindingResult, Model model) {
        bindingResult.addError(new ObjectError("", "message"));
        //если есть id удаляем по id
        if (book.getId() != null) {
            if (bindingResult.hasFieldErrors("id")) {
                updateModelForRemove(model, book, bindingResult);
                return "book_shelf";
            } else {
                bookService.removeBookById(book.getId());
                return "redirect:/books/shelf";
            }
            //если есть автор удаляем по автору
        } else if (!book.getAuthor().equals("")) {
            if (bindingResult.hasFieldErrors("author")) {
                updateModelForRemove(model, book, bindingResult);
                return "book_shelf";
            } else {
                bookService.removeAllByAuthor(book.getAuthor());
                return "redirect:/books/shelf";
            }
            //если есть титульник удаляем по титульнику
        } else if (!book.getTitle().equals("")) {
            if (bindingResult.hasFieldErrors("title")) {
                updateModelForRemove(model, book, bindingResult);
                return "book_shelf";
            } else {
                bookService.removeAllByTitle(book.getTitle());
                return "redirect:/books/shelf";
            }
            //если есть размер удаляем по размеру
        } else if (book.getSize() != null) {
            if (bindingResult.hasFieldErrors("size")) {
                updateModelForRemove(model, book, bindingResult);
                return "book_shelf";
            } else {
                bookService.removeAllBySize(book.getSize());
                return "redirect:/books/shelf";
            }
            //иначе нет ничего возращаем на заглавную
        } else {
            updateModelForRemove(model, book, bindingResult);
            return "book_shelf";
        }
    }

    private void updateModelForRemove(Model model, Book book, BindingResult bindingResult) {
        model.addAttribute("book", new Book());
        model.addAttribute("book2Remove", book);
        model.addAttribute("book2Filter", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "book2Remove", bindingResult);
    }

    private void updateModelForSave(Model model, Book book) {
        model.addAttribute("book", book);
        model.addAttribute("book2Remove", new Book());
        model.addAttribute("book2Filter", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
    }

    private void updateModelForShelf(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("book2Remove", new Book());
        model.addAttribute("book2Filter", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String name = file.getOriginalFilename();
        byte[] bytes = file.getBytes();

        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "external_uploads");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
            stream.write(bytes);
        } catch (FileNotFoundException ex) {
            throw new BookShelfLoginException("Please select file");
        }
        logger.info("new file saved at: " + serverFile.getAbsolutePath());

        return "redirect:/books/shelf";
    }

    @ExceptionHandler(BookShelfLoginException.class)
    public String handleError(Model model, BookShelfLoginException exception) {
        model.addAttribute("fileNotFound", exception.getMassage());
        return "errors/fileNotFound";
    }
}