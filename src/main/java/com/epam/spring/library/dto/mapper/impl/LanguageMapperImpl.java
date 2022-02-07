package com.epam.spring.library.dto.mapper.impl;

import com.epam.spring.library.dto.mapper.LanguageMapper;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LanguageMapperImpl implements LanguageMapper {
    private final LanguageRepository repository;

    @Override
    public Language toLanguage(String code) {
        if (Objects.isNull(code)) {
            return null;
        }

        return repository.getLanguage(code);
    }

    @Override
    public String toDTO(Language language) {
        if (Objects.isNull(language)) {
            return null;
        }

        return language.getCode();
    }

    @Override
    public List<String> toDTO(List<Language> languages) {
        if (Objects.isNull(languages)) {
            return Collections.emptyList();
        }

        return languages.stream()
                        .map(Language::getCode)
                        .collect(Collectors.toList());
    }

    @Override
    public Map<String, String> toDTO(Map<Language, String> map) {
        if (Objects.isNull(map)) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();
        map.forEach((k, v) -> result.put(toDTO(k), v));
        return result;
    }
}
