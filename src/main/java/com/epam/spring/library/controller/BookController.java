package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookAPI;
import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

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

    @Override
    public Set<AuthorDTO> getBookAuthors(String isbn) {
        return service.getBookAuthors(isbn);
    }

    @Override
    public Set<AuthorDTO> setAuthorsOfBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        return service.setAuthorsOfBook(isbn, authorDTOs);
    }

    @Override
    public Set<AuthorDTO> updateAuthorsOfBook(String isbn,
                                              List<AuthorDTO> authorDTOs) {
        return service.updateAuthorsOfBook(isbn, authorDTOs);
    }

    @Override
    public Set<AuthorDTO> addAuthorsToBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        return service.addAuthorsToBook(isbn, authorDTOs);
    }

    @Override
    public void clearAuthorListOfBook(String isbn) {
        service.clearAuthorListOfBook(isbn);
    }

    @Override
    public void deleteAuthorOfBook(String isbn, String authorName) {
        service.deleteAuthorOfBook(isbn, authorName);
    }
}
