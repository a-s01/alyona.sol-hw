package com.epam.spring.library.controller;

import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO getAuthor(@PathVariable String name) {
        return service.getAuthor(name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> getAllAuthors() {
        return service.getAllAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.createAuthor(authorDTO);
    }

    @PatchMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO updateAuthor(@PathVariable String name,
                                  @RequestBody AuthorDTO authorDTO) {
        return service.updateAuthor(name, authorDTO);
    }

    @DeleteMapping("/{name}")
    public void deleteAuthor(@PathVariable String name) {
        service.deleteAuthor(name);
    }
}
