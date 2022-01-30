package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.mapper.BookMapper;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    public BookDTO getBook(String isbn) {
        log.info("get book {}", isbn);
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
        log.info("update book {} with info {}", isbn, bookDTO);
        Book toUpdate = repository.getBook(isbn);
        mapper.updateBook(bookDTO, toUpdate);
        return mapper.toDTO(repository.updateBook(isbn, toUpdate));
    }

    @Override
    public void deleteBook(String isbn) {
        log.info("delete book {}", isbn);
        repository.deleteBook(isbn);
    }
}
