package com.epam.spring.library.service;

import com.epam.spring.library.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO getAuthor(String name);

    AuthorDTO createAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(String name, AuthorDTO authorDTO);

    void deleteAuthor(String name);

    List<AuthorDTO> getAllAuthors();
}
