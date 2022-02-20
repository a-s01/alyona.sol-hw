package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.dto.mapper.BookingMapper;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.repository.BookingRepository;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.service.BookingService;
import com.epam.spring.library.service.validation.BookingValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookingMapper mapper;
    private final BookingValidationService validator;
    private final UserRepository userRepository;

    @Override
    public BookingDTO getBooking(int id) {
        return mapper.toDTO(repository.getBooking(id));
    }

    @Override
    public Page<BookingDTO> getAllBookings(Pageable page) {
        return repository.findAll(page).map(mapper::toDTO);
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = mapper.toBooking(bookingDTO);
        booking.setUser(userRepository.getActiveUser(booking.getUser().getEmail()));
        return mapper.toDTO(
                repository.save(booking));
    }

    @Override
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO) {
        Booking toUpdate = repository.getBooking(id);
        validator.validateUpdate(toUpdate, bookingDTO);
        mapper.updateBooking(bookingDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }
}
