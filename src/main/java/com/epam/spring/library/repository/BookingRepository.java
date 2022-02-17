package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Booking;
import com.epam.spring.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.epam.spring.library.model.Booking.State.CANCELED;
import static com.epam.spring.library.model.Booking.State.DONE;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByUser(User user);

    List<Booking> findByUserAndStateNotIn(User user,
                                          Collection<Booking.State> states);

    default List<Booking> findOpenedBookingByUser(User user) {
        List<Booking.State> closedStates = Arrays.asList(CANCELED, DONE);
        return findByUserAndStateNotIn(user, closedStates);
    }

    default Booking getBooking(int id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Booking with id " + id + " doesn't exists"));
    }
}
