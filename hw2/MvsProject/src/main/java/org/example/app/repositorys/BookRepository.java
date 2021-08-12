package org.example.app.repositorys;

import org.apache.log4j.Logger;
import org.example.app.services.IdProvider;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(context.getBean(IdProvider.class).provideId(book));
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public void removeItemById(String bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                repo.remove(book);
                return;
            }
        }
    }

    @Override
    public void removeAllByAuthor(String author) {
        for (Book book : retreiveAll()) {
            if (book.getAuthor().equals(author)) {
                logger.info("remove books completed: " + book);
                repo.remove(book);
            }
        }
    }

    @Override
    public void removeAllByTitle(String title) {
        for (Book book : retreiveAll()) {
            if (book.getTitle().equals(title)) {
                logger.info("remove books completed: " + book);
                repo.remove(book);
            }
        }
    }

    @Override
    public void removeAllBySize(Integer size) {
        for (Book book : retreiveAll()) {
            if (book.getSize().equals(size)) {
                logger.info("remove books completed: " + book);
                repo.remove(book);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}