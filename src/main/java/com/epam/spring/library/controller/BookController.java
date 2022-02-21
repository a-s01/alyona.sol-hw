package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookAPI;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
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
