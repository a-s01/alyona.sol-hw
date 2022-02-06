package com.epam.spring.library.controller;

import com.epam.spring.library.api.AuthorAPI;
import com.epam.spring.library.dto.AuthorDTO;
import com.epam.spring.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthorController implements AuthorAPI {
    private final AuthorService service;

    @Override
    public AuthorDTO getAuthor(String name) {
        return service.getAuthor(name);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return service.getAllAuthors();
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

    @Override
    public Map<String, String> getAllAuthorNameTranslations(String name) {
        return service.getAllAuthorNameTranslations(name);
    }

    @Override
    public String getAuthorNameTranslationByLangCode(String name,
                                                     String langCode) {
        return service.getAuthorNameTranslationByLangCode(name, langCode);
    }

    @Override
    public Map<String, String> updateAuthorNameTranslation(String name,
                                                           String langCode,
                                                           String nameTranslation) {
        return service.updateAuthorNameTranslation(name, langCode,
                                                   nameTranslation);
    }

    @Override
    public void clearAuthorNameTranslationsList(String name) {
        service.clearAuthorNameTranslationsList(name);
    }

    @Override
    public void deleteAuthorNameTranslationByLangCode(String name,
                                                      String langCode) {
        service.deleteAuthorNameTranslationByLangCode(name, langCode);
    }
}
