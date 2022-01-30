package com.epam.spring.library.dto.mapper.impl;

import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LanguageMapperImpl implements LanguageMapper {
    private final LanguageRepository repository;

    @Override
    public Language toLanguage(String code) {
        if (code == null) {
            return null;
        }

        return repository.getLanguage(code);
    }
}
