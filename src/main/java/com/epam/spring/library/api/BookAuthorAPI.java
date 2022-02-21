package com.epam.spring.library.api;

import com.epam.spring.library.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Tag(name = "Authors of book API")
@Validated
@RequestMapping("api/v1/book")
public interface BookAuthorAPI {

    @Operation(summary = "Get authors of a book by its ISBN number")
    @GetMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> getBookAuthors(@PathVariable @ISBN String isbn);

    @Operation(summary = "Set authors list of a book with provided ISBN number")
    @PostMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.CREATED)
    Set<AuthorDTO> setAuthorsOfBook(@PathVariable @ISBN String isbn,
                                    @RequestBody
                                    @NotEmpty List<@Valid AuthorDTO> authorDTOs);

    @Operation(summary = "Update authors list of a book with provided ISBN "
                         + "number")
    @PutMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> updateAuthorsOfBook(@PathVariable @ISBN String isbn,
                                       @RequestBody
                                       @NotEmpty List<@Valid AuthorDTO> authorDTOs);

    @Operation(summary = "Add authors list to a book with provided ISBN number")
    @PatchMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> addAuthorsToBook(@PathVariable @ISBN String isbn,
                                    @RequestBody
                                    @NotEmpty List<@Valid AuthorDTO> authorDTOs);

    @Operation(summary = "Delete authors list of a book with provided ISBN "
                         + "number")
    @DeleteMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearAuthorListOfBook(@PathVariable @ISBN String isbn);

    @Operation(summary = "Delete specific author of a book with provided "
                         + "ISBN number")
    @DeleteMapping("/{isbn}/authors/{authorName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorOfBook(@PathVariable @ISBN String isbn,
                            @PathVariable @NotBlank
                            @Parameter(description = "author name")
                                    String authorName);
}
