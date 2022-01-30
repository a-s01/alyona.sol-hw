package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.model.Language;

import java.util.List;
import java.util.stream.Collectors;

public interface LanguageMapper {

    Language toLanguage(String code);

    default String toDTO(Language language) {
        if (language == null) {
            return null;
        }

        return language.getCode();
    }

    default List<String> toDTO(List<Language> languages) {
        if (languages == null) {
            return null;
        }

        return languages.stream()
                        .map(lang -> lang.getCode())
                        .collect(Collectors.toList());

    }
}
