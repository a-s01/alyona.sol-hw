package com.epam.spring.library.controller;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> getAllBookings() {
        return service.getAllBookings();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDTO getBooking(@PathVariable int id) {
        return service.getBooking(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        return service.createBooking(bookingDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDTO updateBooking(@PathVariable int id,
                                    @RequestBody BookingDTO bookingDTO) {
        return service.updateBooking(id, bookingDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBooking(@PathVariable int id) {
        service.deleteBooking(id);
    }
}
