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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public BookDTO getBook(String isbn) {
        return mapper.toDTO(repository.getBook(isbn));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return mapper.toDTO(repository.getAllBooks());
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book newBook = mapper.toBook(bookDTO);
        return mapper.toDTO(repository.createBook(newBook));
    }

    @Override
    public BookDTO updateBook(String isbn, BookDTO bookDTO) {
        Book toUpdate = repository.getBook(isbn);
        mapper.updateBook(bookDTO, toUpdate);
        return mapper.toDTO(repository.updateBook(isbn, toUpdate));
    }

    @Override
    public void deleteBook(String isbn) {
        repository.deleteBook(isbn);
    }

    @Override
    public Set<AuthorDTO> getBookAuthors(String isbn) {
        Book book = repository.getBook(isbn);
        return authorMapper.toDTO(book.getAuthors());
    }

    @Override
    public Set<AuthorDTO> setAuthorsOfBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        List<Author> authors = getNewAuthorList(authorDTOs);
        if (!book.getAuthors().isEmpty()) {
            throw new RuntimeException(
                    "author list of book isbn#" + isbn + " is not " + "empty");
        }
        book.getAuthors().addAll(authors);
        return authorMapper.toDTO(book.getAuthors());
    }

    @Override
    public Set<AuthorDTO> updateAuthorsOfBook(String isbn,
                                              List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        List<Author> newAuthorList = getNewAuthorList(authorDTOs);
        book.getAuthors().clear();
        book.getAuthors().addAll(newAuthorList);
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
        Book book = repository.getBook(isbn);
        book.getAuthors().clear();
    }

    @Override
    public void deleteAuthorOfBook(String isbn, String authorName) {
        Book book = repository.getBook(isbn);
        Author author = authorRepository.getAuthor(authorName);
        book.getAuthors().remove(author);
    }

    @Override
    public Set<AuthorDTO> addAuthorsToBook(String isbn,
                                           List<AuthorDTO> authorDTOs) {
        Book book = repository.getBook(isbn);
        List<Author> authors = getNewAuthorList(authorDTOs);
        book.getAuthors().addAll(authors);
        return authorMapper.toDTO(book.getAuthors());
    }
}
