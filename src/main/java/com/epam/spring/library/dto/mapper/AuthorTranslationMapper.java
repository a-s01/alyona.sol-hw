package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.model.AuthorTranslation;

import java.util.Map;
import java.util.Set;

public interface AuthorTranslationMapper {

    AuthorTranslation toAuthorTranslation(String langCode,
                                          String nameTranslation);

    Map<String, String> toDTO(Set<AuthorTranslation> authorTranslations);
}
