package com.epam.spring.library.service;

import com.epam.spring.library.dto.LanguageDTO;

import java.util.List;

public interface LanguageService {
    List<LanguageDTO> getSupportedLanguages();
}
