package org.example.app.services;

import org.example.app.repository.ProjectRepository;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
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

    public boolean removeAllBooksByAuthor(String author) {
        return bookRepo.removeAllByAuthor(author);
    }

    public boolean removeAllByTitle(String title) {
        return bookRepo.removeAllByTitle(title);
    }

    public boolean removeAllBySize(String size) {
        return bookRepo.removeAllBySize(size);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepo.findBooksByAuthor(author);
    }
}