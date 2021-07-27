package org.example.app.repository;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeAllByAuthor(String author) {
        for (Book book : retreiveAll()) {
            if (book.getAuthor().equals(author)) {
                logger.info("remove books completed: " + book);
                repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeAllByTitle(String title) {
        for (Book book : retreiveAll()) {
            if (book.getTitle().equals(title)) {
                logger.info("remove books completed: " + book);
                repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeAllBySize(String size) {
        for (Book book : retreiveAll()) {
            if (book.getSize().equals(size)) {
                logger.info("remove books completed: " + book);
                repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : retreiveAll()) {
            if (author.equals(book.getAuthor())) {
                bookList.add(book);
            }
        }
        return bookList;
    }
}