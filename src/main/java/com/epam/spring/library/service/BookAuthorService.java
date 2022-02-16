package com.epam.spring.library.service;

import com.epam.spring.library.dto.AuthorDTO;

import java.util.List;
import java.util.Set;

public interface BookAuthorService {

    Set<AuthorDTO> getBookAuthors(String isbn);

    Set<AuthorDTO> setAuthorsOfBook(String isbn, List<AuthorDTO> authorDTOs);

    Set<AuthorDTO> updateAuthorsOfBook(String isbn, List<AuthorDTO> authorDTOs);

    void clearAuthorListOfBook(String isbn);

    void deleteAuthorOfBook(String isbn, String authorName);

    Set<AuthorDTO> addAuthorsToBook(String isbn, List<AuthorDTO> authorDTOs);
}
