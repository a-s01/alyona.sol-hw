package com.epam.spring.library.repository.impl.list;

import com.epam.spring.library.model.Booking;
import com.epam.spring.library.repository.BaseRepository;
import com.epam.spring.library.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class BookingRepositoryListImpl implements BookingRepository {
    private final BaseRepository<Booking> repository;

    @Override
    public Booking getBooking(int id) {
        return repository.get(id, Booking::getId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return repository.getAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        return repository.create(booking, Booking::getId);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return repository.update(booking, Booking::getId);
    }

    @Override
    public void deleteBooking(int id) {
        repository.delete(id, Booking::getId);
    }
}
