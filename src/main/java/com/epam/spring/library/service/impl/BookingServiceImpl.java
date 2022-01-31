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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookRepository bookRepository;
    private final BookingMapper mapper;
    private final BookMapper bookMapper;

    @Override
    public BookingDTO getBooking(int id) {
        log.info("get booking id#{}", id);
        return mapper.toDTO(repository.getBooking(id));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        log.info("get all bookings");
        return mapper.toDTO(repository.getAllBookings());
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        log.info("create booking with info {}", bookingDTO);
        Booking newBooking = mapper.toBooking(bookingDTO);
        return mapper.toDTO(repository.createBooking(newBooking));
    }

    @Override
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        log.info("update booking id#{} with info {}", id, bookingDTO);
        Booking toUpdate = repository.getBooking(id);
        mapper.updateBooking(bookingDTO, toUpdate);
        return mapper.toDTO(repository.updateBooking(toUpdate));
    }

    @Override
    public void deleteBooking(int id) {
        log.info("delete booking id#{}", id);
        repository.deleteBooking(id);
    }

    @Override
    public List<BookDTO> addBookToBooking(int id, List<BookDTO> bookDTOs) {
        log.info("add books to booking id#{}: {}", id, bookDTOs);
        List<Book> books = bookDTOs.stream()
                                   .map(BookDTO::getIsbn)
                                   .map(bookRepository::getBook)
                                   .collect(Collectors.toList());
        Booking booking = repository.getBooking(id);
        booking.getBooks().addAll(books);
        repository.updateBooking(booking);
        return bookMapper.toDTO(books);
    }

    @Override
    public void deleteBookFromBooking(int id, String isbn) {
        log.info("delete book isbn#{} from booking id#{}", isbn, id);
        Book book = bookRepository.getBook(isbn);
        Booking booking = repository.getBooking(id);
        booking.getBooks().remove(book);
        repository.updateBooking(booking);
    }

    @Override
    public List<BookDTO> getBooksInBooking(int id) {
        log.info("get all books in booking id#{}", id);
        Booking booking = repository.getBooking(id);
        return bookMapper.toDTO(booking.getBooks());
    }

    @Override
    public List<BookDTO> updateBooksInBooking(int id, List<BookDTO> bookDTOs) {
        log.info("update books in booking id#{} with new list {}", id,
                 bookDTOs);
        Booking booking = repository.getBooking(id);
        List<Book> newBookList = bookDTOs.stream()
                                         .map(BookDTO::getIsbn)
                                         .map(bookRepository::getBook)
                                         .collect(Collectors.toList());
        booking.getBooks().clear();
        booking.getBooks().addAll(newBookList);
        return bookMapper.toDTO(newBookList);
    }

    @Override
    public void clearBookListInBooking(int id) {
        log.info("delete all books from booking id#{}", id);
        Booking booking = repository.getBooking(id);
        booking.getBooks().clear();
    }
}
