package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Author {
    private int id;
    private String defaultName;
    private Language defaultLanguage;
    private Map<Language, String> i18Names;
}
