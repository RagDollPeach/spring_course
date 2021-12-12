package com.example.repository;

import com.example.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthors_Name(String name);

    @Query("from Book")
    List<Book> customFindAllBooks();

    //NEW BOOK REST REPOSITORY COMMANDS

    List<Book> findAllByPubDateBetween(LocalDate from, LocalDate to);

    List<Book> findBooksByAuthorsNameContaining(String authorFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBookByDiscountBetween(Double min , Double max);

    List<Book> findBooksByDiscountIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value="SELECT * FROM book WHERE discount = (SELECT MAX(discount) FROM book)", nativeQuery=true)
    List<Book> getBooksWithMaxDiscount();
}
