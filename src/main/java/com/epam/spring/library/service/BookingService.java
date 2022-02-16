package com.epam.spring.library.service;

import com.epam.spring.library.dto.BookingDTO;

import java.util.List;

public interface BookingService {

    BookingDTO getBooking(int id);

    List<BookingDTO> getAllBookings();

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(int id, BookingDTO bookingDTO);
}
