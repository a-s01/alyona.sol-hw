package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.LanguageDTO;
import com.epam.spring.library.model.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageDTO toDTO(Language language);
    Language toLanguage(LanguageDTO languageDTO);
}
