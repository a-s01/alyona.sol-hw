package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.mapper.BookMapper;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
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

    private Book setBookDefaults(Book book) {
        if (book.getKeepPeriod() <= 0) {
            book.setKeepPeriod(bookDefaults.getKeepPeriod());
        }

        return book;
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
}
