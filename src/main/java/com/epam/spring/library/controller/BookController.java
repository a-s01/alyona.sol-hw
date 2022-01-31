package com.epam.spring.library.controller;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBook(@PathVariable String isbn) {
        return service.getBook(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return service.createBook(bookDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @PatchMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO updateBook(@PathVariable String isbn,
                              @RequestBody BookDTO bookDTO) {
        return service.updateBook(isbn, bookDTO);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String isbn) {
        service.deleteBook(isbn);
    }
}
