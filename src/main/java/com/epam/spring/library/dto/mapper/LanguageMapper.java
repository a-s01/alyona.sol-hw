package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.LanguageDTO;
import com.epam.spring.library.model.Language;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageDTO toDTO(Language language);
    Language toLanguage(LanguageDTO languageDTO);
    List<LanguageDTO> toDTO(List<Language> languages);
}
