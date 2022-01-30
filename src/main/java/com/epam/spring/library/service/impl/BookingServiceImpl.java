package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.dto.mapper.BookingMapper;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.repository.BookingRepository;
import com.epam.spring.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookingMapper mapper;

    @Override
    public BookingDTO getBooking(int id) {
        log.info("get booking {}", id);
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
        log.info("update booking {} with info {}", id, bookingDTO);
        Booking toUpdate = repository.getBooking(id);
        mapper.updateBooking(bookingDTO, toUpdate);
        return mapper.toDTO(repository.updateBooking(toUpdate));
    }

    @Override
    public void deleteBooking(int id) {
        log.info("delete booking {}", id);
        repository.deleteBooking(id);
    }
}
