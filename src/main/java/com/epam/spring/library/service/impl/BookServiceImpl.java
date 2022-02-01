package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.mapper.AuthorMapper;
import com.epam.spring.library.dto.mapper.BookMapper;
import com.epam.spring.library.model.Author;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.AuthorRepository;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public BookDTO getBook(String isbn) {
        log.info("get book by isbn {}", isbn);
        return mapper.toDTO(repository.getBook(isbn));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        log.info("get all books");
        return mapper.toDTO(repository.getAllBooks());
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        log.info("create book with info {}", bookDTO);
        Book newBook = mapper.toBook(bookDTO);
        return mapper.toDTO(repository.createBook(newBook));
    }

    @Override
    public BookDTO updateBook(String isbn, BookDTO bookDTO) {
        log.info("update book isbn#{} with info {}", isbn, bookDTO);
        Book toUpdate = repository.getBook(isbn);
        mapper.updateBook(bookDTO, toUpdate);
        return mapper.toDTO(repository.updateBook(isbn, toUpdate));
    }

    @Override
    public void deleteBook(String isbn) {
        log.info("delete book isbn#{}", isbn);
        repository.deleteBook(isbn);
        log.info("successfully deleted book {}", isbn);
    }

    @Override
    public Set<AuthorDTO> getBookAuthors(String isbn) {
        log.info("get book isbn#{} authors", isbn);
        Book book = repository.getBook(isbn);
        return authorMapper.toDTO(book.getAuthors());
    }

    @Override
    public Set<AuthorDTO> setAuthorsOfBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        log.info("set authors list of book isbn#{}: {}", isbn, authorDTOs);
        Book book = repository.getBook(isbn);
        List<Author> authors = getNewAuthorList(authorDTOs);
        if (!book.getAuthors().isEmpty()) {
            throw new RuntimeException("author list of book isbn#" + isbn + " is not "
                                       + "empty");
        }
        book.getAuthors().addAll(authors);
        log.info("successfully set author list of book isbn#{}", isbn);
        return authorMapper.toDTO(book.getAuthors());
    }

    @Override
    public Set<AuthorDTO> updateAuthorsOfBook(String isbn,
                                              List<AuthorDTO> authorDTOs) {
        log.info("update authors of book isbn#{}: {}", isbn, authorDTOs);
        Book book = repository.getBook(isbn);
        List<Author> newAuthorList = getNewAuthorList(authorDTOs);
        book.getAuthors().clear();
        book.getAuthors().addAll(newAuthorList);
        log.info("authors of book isbn#{} successfully updated", isbn);
        return authorMapper.toDTO(book.getAuthors());
    }

    private List<Author> getNewAuthorList(List<AuthorDTO> authorDTOs) {
        return authorDTOs.stream()
                         .map(AuthorDTO::getDefaultName)
                         .map(authorRepository::getAuthor)
                         .collect(Collectors.toList());
    }

    @Override
    public void clearAuthorListOfBook(String isbn) {
        log.info("delete all authors from book isbn#{}", isbn);
        Book book = repository.getBook(isbn);
        book.getAuthors().clear();
        log.info("authors of book isbn#{} successfully deleted", isbn);
    }

    @Override
    public void deleteAuthorOfBook(String isbn, String authorName) {
        log.info("delete author with name {} from book isbn#{}", authorName,
                 isbn);
        Book book = repository.getBook(isbn);
        Author author = authorRepository.getAuthor(authorName);
        book.getAuthors().remove(author);
        log.info("successfully deleted author with name {} from book isbn#{}",
                 authorName, isbn);
    }

    @Override
    public Set<AuthorDTO> addAuthorsToBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        log.info("add authors list to book isbn#{}: {}", isbn, authorDTOs);
        Book book = repository.getBook(isbn);
        List<Author> authors = getNewAuthorList(authorDTOs);
        book.getAuthors().addAll(authors);
        log.info("book isbn#{}: author list successfully added", isbn);
        return authorMapper.toDTO(book.getAuthors());
    }
}
