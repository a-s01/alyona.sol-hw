package com.epam.spring.library.repository;

import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    default Booking getBooking(int id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Booking with id " + id + " doesn't exists"));
    }
}
