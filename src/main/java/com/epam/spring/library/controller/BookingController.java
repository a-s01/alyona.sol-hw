package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookingAPI;
import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController implements BookingAPI {
    private final BookingService service;

    @Override
    public List<BookingDTO> getAllBookings() {
        return service.getAllBookings();
    }

    @Override
    public BookingDTO getBooking(int id) {
        return service.getBooking(id);
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return service.createBooking(bookingDTO);
    }

    @Override
    // TODO: add status and place validation here
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        return service.updateBooking(id, bookingDTO);
    }

    @Override
    public void deleteBooking(int id) {
        service.deleteBooking(id);
    }

    @Override
    public List<BookDTO> getBooksInBooking(int id) {
        return service.getBooksInBooking(id);
    }

    @Override
    public List<BookDTO> addBookListToBooking(int id,
                                              @RequestBody
                                                      List<BookDTO> bookDTOs) {
        return service.addBookToBooking(id, bookDTOs);
    }

    @Override
    public List<BookDTO> updateBooksListInBooking(int id,
                                                  @RequestBody
                                                          List<BookDTO> bookDTOs) {
        return service.updateBooksListInBooking(id, bookDTOs);
    }

    @Override
    public void deleteBookFromBooking(int id, String isbn) {
        service.deleteBookFromBooking(id, isbn);
    }

    @Override
    public void clearBookListInBooking(int id) {
        service.clearBookListInBooking(id);
    }
}
