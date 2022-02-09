package com.epam.spring.library.validation.service.impl;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.exception.InvalidStateException;
import com.epam.spring.library.exception.ServiceException;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.model.Booking.Place;
import com.epam.spring.library.model.Booking.State;
import com.epam.spring.library.validation.service.BookingValidationService;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;

import static com.epam.spring.library.model.Booking.Place.USER;
import static com.epam.spring.library.model.Booking.State.*;

@Service
class BookingValidationServiceImpl implements BookingValidationService {
    private final Map<State, EnumSet<State>> nextStateOptions =
            new EnumMap<>(State.class);

    BookingValidationServiceImpl() {
        nextStateOptions.put(NEW, EnumSet.of(BOOKED, CANCELED));
        nextStateOptions.put(BOOKED, EnumSet.of(DELIVERED, CANCELED, NEW));
        nextStateOptions.put(DELIVERED, EnumSet.of(DONE));
        nextStateOptions.put(CANCELED, EnumSet.noneOf(State.class));
        nextStateOptions.put(DONE, EnumSet.noneOf(State.class));
        nextStateOptions.put(UNKNOWN, EnumSet.noneOf(State.class));
    }

    @Override
    public void validateUpdate(Booking original, BookingDTO updated) {
        if (Objects.isNull(updated) || Objects.isNull(original)) {
            throw new ServiceException(this.getClass().getSimpleName()
                                       + ": original or updated booking is "
                                       + "null");
        }
        State newState =
                Objects.isNull(updated.getState()) ? original.getState()
                                                   : State.valueOf(
                                                           updated.getState());
        Place newPlace =
                Objects.isNull(updated.getLocated()) ? original.getLocated()
                                                     : Place.valueOf(
                                                             updated.getLocated());
        checkPlaceOnUpdate(newState, newPlace);
        checkStateOnUpdate(original.getState(), newState);
    }

    @Override
    public void validateBookListChanges(Booking original) {
        if (Objects.isNull(original)) {
            throw new ServiceException(this.getClass().getSimpleName()
                                       + ": original booking is null");
        }
        if (!Objects.equals(original.getState(), NEW)) {
            throw new InvalidStateException(
                    "Book list cannot be modified in not NEW state");
        }
    }

    private void checkPlaceOnUpdate(State newState, Place newPlace) {
        final String msg = "Invalid location: ";

        if (Objects.equals(newPlace, Place.UNKNOWN)) {
            throw new InvalidStateException(msg + "cannot be UNKNOWN");
        }

        if (!Objects.equals(newState, DELIVERED)
                && Objects.equals(newPlace, USER)) {
            throw new InvalidStateException(
                    msg + "cannot be USER for not DELIVERED booking");
        }
    }

    private void checkStateOnUpdate(State original, State updated) {
        if (Objects.equals(original, updated)) {
            return;
        }
        if (!nextStateOptions.get(original).contains(updated)) {
            throw new InvalidStateException(
                    "Invalid state: can only be one of " + nextStateOptions.get(
                            original));
        }
    }
}
