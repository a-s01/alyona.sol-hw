package com.epam.spring.library.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class AuthorDTO {
    private String defaultName;
    private LanguageDTO defaultLanguage;
    private Map<LanguageDTO, String> i18Names;
}
