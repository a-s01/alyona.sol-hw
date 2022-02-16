package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.dto.mapper.BookMapper;
import com.epam.spring.library.exception.EntityFieldIsNotEmpty;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final Book bookDefaults;

    @Override
    public BookDTO getBook(String isbn) {
        return mapper.toDTO(repository.getBook(isbn));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        return mapper.toDTO(
                repository.save(setBookDefaults(mapper.toBook(bookDTO))));
    }

    @Override
    public BookDTO updateBook(String isbn, BookDTO bookDTO) {
        Book toUpdate = repository.getBook(isbn);
        mapper.updateBook(bookDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }

    @Override
    public void deleteBook(String isbn) {
        repository.deleteByIsbn(isbn);
    }

    @Override
    public Set<AuthorDTO> getBookAuthors(String isbn) {
        return authorMapper.toDTO(repository.getBook(isbn).getAuthors());
    }

    @Override
    public Set<AuthorDTO> setAuthorsOfBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        if (!book.getAuthors().isEmpty()) {
            throw new EntityFieldIsNotEmpty(
                    "author list of book isbn#" + isbn + " is not " + "empty");
        }
        book.getAuthors().addAll(getNewAuthorList(authorDTOs));
        return authorMapper.toDTO(book.getAuthors());
    }

    @Override
    public Set<AuthorDTO> updateAuthorsOfBook(String isbn,
                                              List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        book.getAuthors().clear();
        book.getAuthors().addAll(getNewAuthorList(authorDTOs));
        return authorMapper.toDTO(book.getAuthors());
    }

    private List<Author> getNewAuthorList(List<AuthorDTO> authorDTOs) {
        return authorDTOs.stream()
                         .map(AuthorDTO::getDefaultName)
                         .map(authorRepository::getByName)
                         .collect(Collectors.toList());
    }

    @Override
    public void clearAuthorListOfBook(String isbn) {
        repository.getBook(isbn).getAuthors().clear();
    }

    @Override
    public void deleteAuthorOfBook(String isbn, String authorName) {
        repository.getBook(isbn)
                  .getAuthors()
                  .remove(authorRepository.getByName(authorName));
    }

    @Override
    public Set<AuthorDTO> addAuthorsToBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        repository.getBook(isbn)
                  .getAuthors()
                  .addAll(getNewAuthorList(authorDTOs));
        return authorMapper.toDTO(repository.getBook(isbn).getAuthors());
    }

    private Book setBookDefaults(Book book) {
        if (book.getKeepPeriod() <= 0) {
            book.setKeepPeriod(bookDefaults.getKeepPeriod());
        }

        return book;
    }
}
