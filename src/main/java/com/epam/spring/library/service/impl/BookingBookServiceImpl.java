package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.mapper.BookMapper;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.repository.BookingRepository;
import com.epam.spring.library.service.BookingBookService;
import com.epam.spring.library.service.validation.BookingValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookingBookServiceImpl implements BookingBookService {
    private final BookingRepository repository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookingValidationService validator;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public Set<BookDTO> addBookToBooking(int id, Set<BookDTO> bookDTOs) {
        Booking booking = repository.getBooking(id);
        validator.validateBookListChanges(booking);
        Set<Book> books = bookDTOs
                .stream()
                .map(BookDTO::getIsbn)
                .map(bookRepository::getBook)
                .collect(Collectors.toSet());
        booking.getBooks().addAll(books);
        repository.save(booking);
        return bookMapper.toDTO(books);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void deleteBookFromBooking(int id, String isbn) {
        Booking booking = repository.getBooking(id);
        validator.validateBookListChanges(booking);
        booking.getBooks().remove(bookRepository.getBook(isbn));
        repository.save(booking);
    }

    @Override
    public Set<BookDTO> getBooksInBooking(int id) {
        return bookMapper.toDTO(repository.getBooking(id).getBooks());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public Set<BookDTO> updateBooksListInBooking(int id,
                                                 Set<BookDTO> bookDTOs) {
        Booking booking = repository.getBooking(id);
        validator.validateBookListChanges(booking);
        Set<Book> newBookList = bookDTOs
                .stream()
                .map(BookDTO::getIsbn)
                .map(bookRepository::getBook)
                .collect(Collectors.toSet());
        booking.getBooks().clear();
        booking.getBooks().addAll(newBookList);
        return bookMapper.toDTO(newBookList);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void clearBookListInBooking(int id) {
        validator.validateBookListChanges(repository.getBooking(id));
        repository.getBooking(id).getBooks().clear();
    }
}
