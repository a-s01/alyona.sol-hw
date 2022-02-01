package com.epam.spring.library.service;

import com.epam.spring.library.dto.AuthorDTO;

import java.util.List;
import java.util.Map;

public interface AuthorService {

    AuthorDTO getAuthor(String name);

    AuthorDTO createAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(String name, AuthorDTO authorDTO);

    void deleteAuthor(String name);

    List<AuthorDTO> getAllAuthors();

    Map<String, String> getAuthorI18Names(String name);

    Map<String, String> updateAuthorNameTranslation(String name,
                                                    String langCode,
                                                    String nameTranslation);

    void clearAuthorI18Names(String name);

    void deleteAuthorNameTranslationByLangCode(String name, String langCode);

    String getAuthorNameTranslationByLangCode(String name, String langCode);
}
