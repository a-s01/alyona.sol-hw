package com.epam.spring.library.controller;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String isbn) {
        service.deleteBook(isbn);
    }

    @GetMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    public Set<AuthorDTO> getBookAuthors(@PathVariable String isbn) {
        return service.getBookAuthors(isbn);
    }

    @PostMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Set<AuthorDTO> setAuthorsOfBook(@PathVariable String isbn,
                                           @RequestBody List<AuthorDTO> authorDTOs) {
        return service.setAuthorsOfBook(isbn, authorDTOs);
    }

    @PutMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    public Set<AuthorDTO> updateAuthorsOfBook(@PathVariable String isbn,
                                              @RequestBody List<AuthorDTO> authorDTOs) {
        return service.updateAuthorsOfBook(isbn, authorDTOs);
    }

    @PatchMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    public Set<AuthorDTO> addAuthorsToBook(@PathVariable String isbn,
                                              @RequestBody List<AuthorDTO> authorDTOs) {
        return service.addAuthorsToBook(isbn, authorDTOs);
    }

    @DeleteMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearAuthorListOfBook(@PathVariable String isbn) {
        service.clearAuthorListOfBook(isbn);
    }

    @DeleteMapping("/{isbn}/authors/{authorName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorOfBook(@PathVariable String isbn,
                                   @PathVariable String authorName) {
        service.deleteAuthorOfBook(isbn, authorName);
    }
}
