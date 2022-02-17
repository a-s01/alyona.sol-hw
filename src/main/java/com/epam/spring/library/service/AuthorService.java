package com.epam.spring.library.service;

import com.epam.spring.library.dto.AuthorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {

    AuthorDTO getAuthor(String name);

    AuthorDTO createAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(String name, AuthorDTO authorDTO);

    void deleteAuthor(String name);

    Page<AuthorDTO> getAllAuthors(Pageable page);
}
