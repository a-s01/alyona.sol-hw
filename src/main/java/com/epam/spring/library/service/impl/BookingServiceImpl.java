package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.dto.mapper.BookMapper;
import com.epam.spring.library.dto.mapper.BookingMapper;
import com.epam.spring.library.model.Book;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.repository.BookRepository;
import com.epam.spring.library.repository.BookingRepository;
import com.epam.spring.library.service.BookingService;
import com.epam.spring.library.validation.service.BookingValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookRepository bookRepository;
    private final BookingMapper mapper;
    private final BookMapper bookMapper;
    private final BookingValidationService validator;

    @Override
    public BookingDTO getBooking(int id) {
        return mapper.toDTO(repository.getBooking(id));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return mapper.toDTO(repository.getAllBookings());
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return mapper.toDTO(
                repository.createBooking(mapper.toBooking(bookingDTO)));
    }

    @Override
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        Booking toUpdate = repository.getBooking(id);
        validator.validateUpdate(toUpdate, bookingDTO);
        mapper.updateBooking(bookingDTO, toUpdate);
        return mapper.toDTO(repository.updateBooking(toUpdate));
    }

    @Override
    public List<BookDTO> addBookToBooking(int id, List<BookDTO> bookDTOs) {
        Booking booking = repository.getBooking(id);
        validator.validateBookListChanges(booking);
        List<Book> books = bookDTOs
                .stream()
                .map(BookDTO::getIsbn)
                .map(bookRepository::getBook)
                .collect(Collectors.toList());
        booking.getBooks().addAll(books);
        repository.updateBooking(booking);
        return bookMapper.toDTO(books);
    }

    @Override
    public void deleteBookFromBooking(int id, String isbn) {
        Booking booking = repository.getBooking(id);
        validator.validateBookListChanges(booking);
        booking.getBooks().remove(bookRepository.getBook(isbn));
        repository.updateBooking(booking);
    }

    @Override
    public List<BookDTO> getBooksInBooking(int id) {
        return bookMapper.toDTO(repository.getBooking(id).getBooks());
    }

    @Override
    public List<BookDTO> updateBooksListInBooking(int id,
                                                  List<BookDTO> bookDTOs) {
        Booking booking = repository.getBooking(id);
        validator.validateBookListChanges(booking);
        List<Book> newBookList = bookDTOs
                .stream()
                .map(BookDTO::getIsbn)
                .map(bookRepository::getBook)
                .collect(Collectors.toList());
        booking.getBooks().clear();
        booking.getBooks().addAll(newBookList);
        return bookMapper.toDTO(newBookList);
    }

    @Override
    public void clearBookListInBooking(int id) {
        validator.validateBookListChanges(repository.getBooking(id));
        repository.getBooking(id).getBooks().clear();
    }
}
