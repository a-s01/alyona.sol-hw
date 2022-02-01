package com.epam.spring.library.repository.impl.list;

import com.epam.spring.library.model.Book;
import com.epam.spring.library.repository.BaseRepository;
import com.epam.spring.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookRepositoryListImpl implements BookRepository {
    private final BaseRepository<Book> repository;

    @Override
    public Book getBook(String isbn) {
        return repository.get(isbn, Book::getIsbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.getAll();
    }

    @Override
    public Book createBook(Book book) {
        return repository.create(book, Book::getIsbn);
    }

    @Override
    public Book updateBook(String isbn, Book book) {
        return repository.update(book, Book::getIsbn);
    }

    @Override
    public void deleteBook(String isbn) {
        repository.delete(isbn, Book::getIsbn);
    }
}
