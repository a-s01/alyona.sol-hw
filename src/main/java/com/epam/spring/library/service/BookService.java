package com.epam.spring.library.service;

import com.epam.spring.library.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookDTO getBook(String isbn);

    Page<BookDTO> getAllBooks(Pageable page);

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(String isbn, BookDTO bookDTO);

    void deleteBook(String isbn);
}
