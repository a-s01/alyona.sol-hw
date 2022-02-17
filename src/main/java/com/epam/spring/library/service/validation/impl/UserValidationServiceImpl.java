package com.epam.spring.library.service.validation.impl;

import com.epam.spring.library.exception.InvalidStateException;
import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.BookingRepository;
import com.epam.spring.library.service.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserValidationServiceImpl implements UserValidationService {
    private final BookingRepository bookingRepository;

    @Override
    public void validateDelete(User user) {
        if (!bookingRepository.findOpenedBookingByUser(user).isEmpty()) {
            throw new InvalidStateException(
                    "User has opened bookings, unable" + " to delete her");
        }
    }
}
