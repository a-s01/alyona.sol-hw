package com.epam.spring.library.repository;

import com.epam.spring.library.model.Book;

import java.util.List;

public interface BookRepository {

    Book getBook(String isbn);

    List<Book> getAllBooks();

    Book createBook(Book book);

    Book updateBook(String isbn, Book book);

    void deleteBook(String isbn);
}
