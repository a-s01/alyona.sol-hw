package com.epam.spring.library.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Language API")
@RequestMapping("api/v1/language")
public interface LanguageAPI {

    @Operation(summary = "Get all supported languages")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<String> getSupportedLanguages();
}
