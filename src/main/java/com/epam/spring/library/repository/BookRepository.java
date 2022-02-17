package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByAuthorsContaining(Author author);

    default Book getBook(String isbn) {
        return findByIsbn(isbn).orElseThrow(
                () -> new EntityNotFoundException(
                        "Book with ISBN " + isbn + " was not found."));
    }

    default void deleteByIsbn(String isbn) {
        findByIsbn(isbn).ifPresent(this::delete);
    }
}
