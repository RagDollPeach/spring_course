package org.example.app.services;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);

    boolean removeAllByAuthor(String author);

    boolean removeAllByTitle(String title);

    boolean removeAllBySize(Integer size);
}