package com.epam.spring.library.dto.mapper.impl;

import com.epam.spring.library.dto.mapper.AuthorTranslationMapper;
import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.model.AuthorTranslation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
class AuthorTranslationMapperImpl implements AuthorTranslationMapper {
    private final LanguageMapper languageMapper;

    @Override
    public AuthorTranslation toAuthorTranslation(String langCode,
                                                 String nameTranslation) {
        return new AuthorTranslation(languageMapper.toLanguage(langCode),
                                     nameTranslation);
    }

    @Override
    public Map<String, String> toDTO(Set<AuthorTranslation> authorTranslations) {
        Map<String, String> result = new HashMap<>();
        authorTranslations.forEach(
                tr -> result.put(tr.getLanguage().getCode(), tr.getName()));
        return result;
    }
}
