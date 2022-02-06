package com.epam.spring.library.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Language controller is responsible for handle request related to
 * apps supported languages. Can be extended, if there's a need in language
 * editing (wasn't required in original project TR)
 */
@RequestMapping("api/v1/language")
public interface LanguageAPI {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<String> getSupportedLanguages();
}
