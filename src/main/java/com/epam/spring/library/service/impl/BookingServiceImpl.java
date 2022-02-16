package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.dto.mapper.BookingMapper;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.repository.BookingRepository;
import com.epam.spring.library.service.BookingService;
import com.epam.spring.library.validation.service.BookingValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookingMapper mapper;
    private final BookingValidationService validator;

    @Override
    public BookingDTO getBooking(int id) {
        return mapper.toDTO(repository.getBooking(id));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return mapper.toDTO(
                repository.save(mapper.toBooking(bookingDTO)));
    }

    @Override
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        Booking toUpdate = repository.getBooking(id);
        validator.validateUpdate(toUpdate, bookingDTO);
        mapper.updateBooking(bookingDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }
}
