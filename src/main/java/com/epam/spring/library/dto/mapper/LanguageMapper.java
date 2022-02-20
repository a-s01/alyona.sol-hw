package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.model.Language;

import java.util.List;

public interface LanguageMapper {
    /**
     * LanguageDTO seems to be an overhead, as we need only a String
     * representing language code. Also, I want to retrieve actual supported
     * language from database in mapping (not sure if it's ok on this level,
     * isn't it?). That's why I write custom mapper and don't use MapStruct here
     */

    /**
     * Must return language supported by this app, exception otherwise
     *
     * @param code iso 2- or 3-letter language code
     * @return object of supported language specified by code
     */
    Language toLanguage(String code);

    String toDTO(Language language);

    List<String> toDTO(List<Language> languages);
}
