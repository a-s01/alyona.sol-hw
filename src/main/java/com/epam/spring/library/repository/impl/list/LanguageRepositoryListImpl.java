package com.epam.spring.library.repository.impl.list;

import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class LanguageRepositoryListImpl implements LanguageRepository {

    private final List<Language> supportedLanguages;

    public LanguageRepositoryListImpl(@Qualifier("supportedLanguages")
                                              List<Language> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    @Override
    public List<Language> getSupportedLanguages() {
        return new ArrayList<>(supportedLanguages);
    }

    @Override
    public Language getLanguage(String code) {
        return supportedLanguages.stream()
                                 .filter(lang -> lang.getCode()
                                                     .equals(code))
                                 .findFirst()
                                 .orElseThrow(IllegalArgumentException::new);
    }
}
