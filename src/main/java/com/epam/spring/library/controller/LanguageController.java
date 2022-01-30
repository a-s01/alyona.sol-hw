package com.epam.spring.library.controller;

import com.epam.spring.library.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<String> getSupportedLanguages() {
        return service.getSupportedLanguages();
    }
}
