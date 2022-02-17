package com.epam.spring.library.controller;

import com.epam.spring.library.api.LanguageAPI;
import com.epam.spring.library.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Language controller is responsible for handle request related to
 * apps supported languages. Can be extended, if there's a need in language
 * editing (wasn't required in original project TR)
 */
@RestController
@RequiredArgsConstructor
public class LanguageController implements LanguageAPI {
    private final LanguageService service;

    public Page<String> getSupportedLanguages(Pageable page) {
        return service.getSupportedLanguages(page);
    }
}
