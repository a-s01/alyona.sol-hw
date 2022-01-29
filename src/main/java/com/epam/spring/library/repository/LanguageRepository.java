package com.epam.spring.library.repository;

import com.epam.spring.library.model.Language;

import java.util.List;

public interface LanguageRepository {

    List<Language> getSupportedLanguages();
}
