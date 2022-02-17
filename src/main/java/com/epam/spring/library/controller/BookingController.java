package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookingAPI;
import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingController implements BookingAPI {
    private final BookingService service;

    @Override
    public Page<BookingDTO> getAllBookings(Pageable page) {
        return service.getAllBookings(page);
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
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        return service.updateBooking(id, bookingDTO);
    }
}
