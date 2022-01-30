package com.epam.spring.library.repository;

import com.epam.spring.library.model.Booking;

import java.util.List;

public interface BookingRepository {

    Booking getBooking(int id);

    List<Booking> getAllBookings();

    Booking createBooking(Booking booking);

    Booking updateBooking(Booking booking);

    void deleteBooking(int id);
}
