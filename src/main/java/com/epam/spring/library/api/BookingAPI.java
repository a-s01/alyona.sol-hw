package com.epam.spring.library.api;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.BookingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/booking")
public interface BookingAPI {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BookingDTO> getAllBookings();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookingDTO getBooking(@PathVariable int id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookingDTO createBooking(@RequestBody BookingDTO bookingDTO);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookingDTO updateBooking(@PathVariable int id,
                             @RequestBody BookingDTO bookingDTO);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBooking(@PathVariable int id);

    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> getBooksInBooking(@PathVariable int id);

    @PostMapping("/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    List<BookDTO> addBookListToBooking(@PathVariable int id,
                                       @RequestBody List<BookDTO> bookDTOs);

    @PutMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> updateBooksListInBooking(@PathVariable int id,
                                           @RequestBody List<BookDTO> bookDTOs);

    @DeleteMapping("/{id}/books/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBookFromBooking(@PathVariable int id, @PathVariable String isbn);

    @DeleteMapping("/{id}/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearBookListInBooking(@PathVariable int id);
}
