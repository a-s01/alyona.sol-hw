package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookAPI;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController implements BookAPI {
    private final BookService service;

    @Override
    public BookDTO getBook(String isbn) {
        return service.getBook(isbn);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        return service.createBook(bookDTO);
    }

    @Override
    public Page<BookDTO> getAllBooks(Pageable page) {
        return service.getAllBooks(page);
    }

    @Override
    public BookDTO updateBook(String isbn, BookDTO bookDTO) {
        return service.updateBook(isbn, bookDTO);
    }

    @Override
    public void deleteBook(String isbn) {
        service.deleteBook(isbn);
    }
}
