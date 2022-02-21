package com.epam.spring.library.api;

import com.epam.spring.library.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name="Book API")
@Validated
@RequestMapping("api/v1/book")
public interface BookAPI {

    @Operation(summary = "Get a book by its ISBN number")
    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO getBook(@PathVariable @ISBN String isbn);

    @Operation(summary = "Create a book")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookDTO createBook(@RequestBody @Valid BookDTO bookDTO);

    @Operation(summary = "Get all books")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> getAllBooks();

    @Operation(summary = "Update a book with specific ISBN number")
    @PutMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO updateBook(@PathVariable @ISBN String isbn,
                       @RequestBody @Valid BookDTO bookDTO);

    @Operation(summary = "Delete a book by its ISBN number")
    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBook(@PathVariable @ISBN String isbn);
}
