package com.epam.spring.library.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageService {

    Page<String> getSupportedLanguages(Pageable page);
}
