package com.epam.spring.library.controller;

import com.epam.spring.library.api.AuthorAPI;
import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController implements AuthorAPI {
    private final AuthorService service;

    @Override
    public AuthorDTO getAuthor(String name) {
        return service.getAuthor(name);
    }

    @Override
    public Page<AuthorDTO> getAllAuthors(Pageable page) {
        return service.getAllAuthors(page);
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        return service.createAuthor(authorDTO);
    }

    @Override
    public AuthorDTO updateAuthor(String name, AuthorDTO authorDTO) {
        return service.updateAuthor(name, authorDTO);
    }

    @Override
    public void deleteAuthor(String name) {
        service.deleteAuthor(name);
    }
}
