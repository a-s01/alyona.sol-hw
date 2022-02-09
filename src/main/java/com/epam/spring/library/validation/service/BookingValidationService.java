package com.epam.spring.library.validation.service;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.model.Booking;

public interface BookingValidationService {

    void validateUpdate(Booking original, BookingDTO updatedDTO);

    void validateBookListChanges(Booking updated);
}
