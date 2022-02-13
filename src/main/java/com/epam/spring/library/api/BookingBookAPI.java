package com.epam.spring.library.api;

import com.epam.spring.library.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Tag(name = "Books in booking API")
@Validated
@RequestMapping("api/v1/booking")
public interface BookingBookAPI {

    @Operation(summary = "Get books in booking")
    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> getBooksInBooking(
            @PathVariable @Positive @Parameter(description = "booking id")
                    int id);

    @Operation(summary = "Add books to booking")
    @PostMapping("/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    List<BookDTO> addBookListToBooking(
            @PathVariable @Positive @Parameter(description = "booking id")
                    int id,
            @RequestBody @NotEmpty List<@Valid BookDTO> bookDTOs);

    @Operation(summary = "Update books in booking")
    @PutMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> updateBooksListInBooking(
            @PathVariable @Positive @Parameter(description = "booking id")
                    int id,
            @RequestBody @NotEmpty List<@Valid BookDTO> bookDTOs);

    @Operation(summary = "Delete book from booking")
    @DeleteMapping("/{id}/books/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBookFromBooking(
            @PathVariable @Positive @Parameter(description = "booking id")
                    int id,
            @Parameter(description = "ISBN of book which should be deleted")
            @PathVariable @ISBN String isbn);

    @Operation(summary = "Delete all books from booking")
    @DeleteMapping("/{id}/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearBookListInBooking(@PathVariable @Positive int id);
}
