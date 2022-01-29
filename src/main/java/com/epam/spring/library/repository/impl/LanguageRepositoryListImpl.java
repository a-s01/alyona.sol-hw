package com.epam.spring.library.repository.impl;

import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.LanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class LanguageRepositoryListImpl implements LanguageRepository {

    private final List<Language> supportedLanguages;

    public LanguageRepositoryListImpl(@Qualifier("supportedLanguages") List<Language> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    @Override
    public List<Language> getSupportedLanguages() {
        return new ArrayList<>(supportedLanguages);
    }
}
