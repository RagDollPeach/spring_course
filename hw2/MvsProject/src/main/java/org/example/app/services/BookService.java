package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.app.repositorys.BookRepository;
import org.example.app.repositorys.ProjectRepository;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepo;
    private Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    private void defaultInit() {
        logger.info("default INIT in provider in BookService");
    }

    private void defaultDestroy() {
        logger.info("default DESTROY in provider in BookService");
    }

    public boolean hasAllValuesEmpty(Book book) {
        return book.getAuthor().equals("") && book.getTitle().equals("") && book.getSize() == null;
    }
}