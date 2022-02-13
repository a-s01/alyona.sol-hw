package com.epam.spring.library.api;

import com.epam.spring.library.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Tag(name = "Author API")
@Validated
@RequestMapping("api/v1/author")
public interface AuthorAPI {

    @Operation(summary = "Get author by name")
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO getAuthor(@PathVariable @NotBlank String name);

    @Operation(summary = "Get all authors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<AuthorDTO> getAllAuthors();

    @Operation(summary = "Create a new author")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AuthorDTO createAuthor(@RequestBody @Valid AuthorDTO authorDTO);

    @Operation(summary = "Update a existing author")
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO updateAuthor(@PathVariable @NotBlank String name,
                           @RequestBody @Valid AuthorDTO authorDTO);

    @Operation(summary = "Delete a existing author")
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthor(@PathVariable @NotBlank String name);
}
