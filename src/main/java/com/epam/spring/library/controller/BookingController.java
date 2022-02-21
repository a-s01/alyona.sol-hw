package com.epam.spring.library.controller;

import com.epam.spring.library.api.BookingAPI;
import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.service.BookingService;
import lombok.RequiredArgsConstructor;
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
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        return service.updateBooking(id, bookingDTO);
    }
}
