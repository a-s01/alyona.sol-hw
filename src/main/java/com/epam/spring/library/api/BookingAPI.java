package com.epam.spring.library.api;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@Tag(name = "Booking API")
@Validated
@RequestMapping("api/v1/booking")
public interface BookingAPI {

    @Operation(summary = "Get all bookings")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<BookingDTO> getAllBookings(
            @SortDefault(value = "id", direction = Sort.Direction.DESC)
                    Pageable page);

    @Operation(summary = "Get booking by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookingDTO getBooking(@PathVariable @Positive int id);

    @Operation(summary = "Create booking")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookingDTO createBooking(
            @RequestBody @Validated(OnCreate.class) BookingDTO bookingDTO);

    @Operation(summary = "Update booking by id")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookingDTO updateBooking(@PathVariable @Positive int id,
                             @RequestBody @Validated(OnUpdate.class)
                                     BookingDTO bookingDTO);
}
