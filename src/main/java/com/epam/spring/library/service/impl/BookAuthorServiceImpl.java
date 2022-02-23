package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.exception.EntityFieldIsNotEmpty;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.BookAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookAuthorServiceImpl implements BookAuthorService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public Set<AuthorDTO> getBookAuthors(String isbn) {
        return authorMapper.toDTO(repository.getBook(isbn).getAuthors());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public Set<AuthorDTO> setAuthorsOfBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        if (!book.getAuthors().isEmpty()) {
            throw new EntityFieldIsNotEmpty(
                    "author list of book isbn#" + isbn + " is not " + "empty");
        }
        book.getAuthors().addAll(getNewAuthorList(authorDTOs));
        repository.save(book);
        return authorMapper.toDTO(book.getAuthors());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public Set<AuthorDTO> updateAuthorsOfBook(String isbn,
                                              List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        book.getAuthors().clear();
        book.getAuthors().addAll(getNewAuthorList(authorDTOs));
        repository.save(book);
        return authorMapper.toDTO(book.getAuthors());
    }

    private List<Author> getNewAuthorList(List<AuthorDTO> authorDTOs) {
        return authorDTOs.stream()
                         .map(AuthorDTO::getName)
                         .map(authorRepository::getByName)
                         .collect(Collectors.toList());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void clearAuthorListOfBook(String isbn) {
        Book book = repository.getBook(isbn);
        book.getAuthors().clear();
        repository.save(book);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void deleteAuthorOfBook(String isbn, String authorName) {
        Book book = repository.getBook(isbn);
        book.getAuthors().remove(authorRepository.getByName(authorName));
        repository.save(book);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public Set<AuthorDTO> addAuthorsToBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        book.getAuthors().addAll(getNewAuthorList(authorDTOs));
        repository.save(book);
        return authorMapper.toDTO(book.getAuthors());
    }
}
