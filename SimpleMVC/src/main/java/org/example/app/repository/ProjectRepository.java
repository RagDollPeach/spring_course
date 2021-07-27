package org.example.app.repository;

import org.example.web.dto.Book;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);

    boolean removeAllByAuthor(String author);

    boolean removeAllByTitle(String title);

    boolean removeAllBySize(String size);

    List<Book> findBooksByAuthor(String author);
}