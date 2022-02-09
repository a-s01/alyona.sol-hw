package com.epam.spring.library.api;

import com.epam.spring.library.dto.BookDTO;
import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RequestMapping("api/v1/booking")
public interface BookingAPI {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BookingDTO> getAllBookings();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookingDTO getBooking(@PathVariable @Positive int id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookingDTO createBooking(
            @RequestBody @Validated(OnCreate.class) BookingDTO bookingDTO);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookingDTO updateBooking(@PathVariable @Positive int id,
                             @RequestBody @Validated(OnUpdate.class)
                                     BookingDTO bookingDTO);

    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> getBooksInBooking(@PathVariable @Positive int id);

    @PostMapping("/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    List<BookDTO> addBookListToBooking(@PathVariable @Positive int id,
                                       @RequestBody
                                       @NotEmpty List<@Valid BookDTO> bookDTOs);

    @PutMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> updateBooksListInBooking(@PathVariable @Positive int id,
                                           @RequestBody
                                           @NotEmpty List<@Valid BookDTO> bookDTOs);

    @DeleteMapping("/{id}/books/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBookFromBooking(@PathVariable @Positive int id,
                               @PathVariable @ISBN String isbn);

    @DeleteMapping("/{id}/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearBookListInBooking(@PathVariable @Positive int id);
}
