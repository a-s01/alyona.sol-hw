package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findBookByIsbn(String isbn);

    default Book getBook(String isbn) {
        return findBookByIsbn(isbn).orElseThrow(
                () -> new EntityNotFoundException(
                        "Book with ISBN " + isbn + " was not found."));
    }

    default void deleteByIsbn(String isbn) {
        findBookByIsbn(isbn).ifPresent(this::delete);
    }
}
