package com.epam.spring.library.api;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Validated
@RequestMapping("api/v1/book")
public interface BookAPI {

    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO getBook(@PathVariable @ISBN String isbn);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookDTO createBook(@RequestBody @Valid BookDTO bookDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> getAllBooks();

    @PutMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO updateBook(@PathVariable @ISBN String isbn,
                       @RequestBody @Valid BookDTO bookDTO);

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBook(@PathVariable @ISBN String isbn);

    @GetMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> getBookAuthors(@PathVariable @ISBN String isbn);

    @PostMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.CREATED)
    Set<AuthorDTO> setAuthorsOfBook(@PathVariable @ISBN String isbn,
                                    @RequestBody @NotEmpty List<@Valid AuthorDTO> authorDTOs);

    @PutMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> updateAuthorsOfBook(@PathVariable @ISBN String isbn,
                                       @RequestBody @NotEmpty List<@Valid AuthorDTO> authorDTOs);

    @PatchMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> addAuthorsToBook(@PathVariable @ISBN String isbn,
                                    @RequestBody @NotEmpty List<@Valid AuthorDTO> authorDTOs);

    @DeleteMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearAuthorListOfBook(@PathVariable @ISBN String isbn);

    @DeleteMapping("/{isbn}/authors/{authorName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorOfBook(@PathVariable @ISBN String isbn,
                            @PathVariable @NotBlank String authorName);
}
