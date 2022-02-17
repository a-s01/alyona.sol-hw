package com.epam.spring.library.service;

import com.epam.spring.library.dto.BookingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {

    BookingDTO getBooking(int id);

    Page<BookingDTO> getAllBookings(Pageable page);

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(int id, BookingDTO bookingDTO);
}
