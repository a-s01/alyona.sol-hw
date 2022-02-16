package com.epam.spring.library.service;

import com.epam.spring.library.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO getBook(String isbn);

    List<BookDTO> getAllBooks();

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(String isbn, BookDTO bookDTO);

    void deleteBook(String isbn);
}
