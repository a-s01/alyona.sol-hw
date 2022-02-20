package com.epam.spring.library.controller;

import com.epam.spring.library.api.AuthorTranslationAPI;
import com.epam.spring.library.service.AuthorTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthorTranslationController implements AuthorTranslationAPI {
    private final AuthorTranslationService service;

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
