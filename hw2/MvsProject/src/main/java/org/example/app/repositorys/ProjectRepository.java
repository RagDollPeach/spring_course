package org.example.app.repositorys;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    void removeItemById(String bookIdToRemove);

    void removeAllByAuthor(String author);

    void removeAllByTitle(String title);

    void removeAllBySize(Integer size);

}
