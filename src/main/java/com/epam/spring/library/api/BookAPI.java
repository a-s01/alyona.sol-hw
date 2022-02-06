package com.epam.spring.library.api;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("api/v1/book")
public interface BookAPI {

    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO getBook(@PathVariable String isbn);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookDTO createBook(@RequestBody BookDTO bookDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BookDTO> getAllBooks();

    @PatchMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO updateBook(@PathVariable String isbn, @RequestBody BookDTO bookDTO);

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBook(@PathVariable String isbn);

    @GetMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> getBookAuthors(@PathVariable String isbn);

    @PostMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.CREATED)
    Set<AuthorDTO> setAuthorsOfBook(@PathVariable String isbn,
                                    @RequestBody List<AuthorDTO> authorDTOs);

    @PutMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> updateAuthorsOfBook(@PathVariable String isbn,
                                       @RequestBody List<AuthorDTO> authorDTOs);

    @PatchMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorDTO> addAuthorsToBook(@PathVariable String isbn,
                                    @RequestBody List<AuthorDTO> authorDTOs);

    @DeleteMapping("/{isbn}/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearAuthorListOfBook(@PathVariable String isbn);

    @DeleteMapping("/{isbn}/authors/{authorName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorOfBook(@PathVariable String isbn,
                            @PathVariable String authorName);
}
