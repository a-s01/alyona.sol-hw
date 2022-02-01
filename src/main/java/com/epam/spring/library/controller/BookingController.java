package com.epam.spring.library.controller;

import com.epam.spring.library.dto.BookDTO;
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

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    // TODO: add status and place validation here
    public BookingDTO updateBooking(@PathVariable int id,
                                    @RequestBody BookingDTO bookingDTO) {
        return service.updateBooking(id, bookingDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable int id) {
        service.deleteBooking(id);
    }

    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getBooksInBooking(@PathVariable int id) {
        return service.getBooksInBooking(id);
    }

    @PostMapping("/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookDTO> addBookListToBooking(@PathVariable int id,
                                              @RequestBody List<BookDTO> bookDTOs) {
        return service.addBookToBooking(id, bookDTOs);
    }

    @PutMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> updateBooksInBooking(@PathVariable int id,
                                              @RequestBody List<BookDTO> bookDTOs) {
        return service.updateBooksInBooking(id, bookDTOs);
    }

    @DeleteMapping("/{id}/books/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookFromBooking(@PathVariable int id,
                                      @PathVariable String isbn) {
        service.deleteBookFromBooking(id, isbn);
    }

    @DeleteMapping("/{id}/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearBookListInBooking(@PathVariable int id) {
        service.clearBookListInBooking(id);
    }
}
