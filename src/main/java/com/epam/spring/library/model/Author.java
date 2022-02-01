package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Author implements Entity {
    private int id;
    private String defaultName;
    private Language defaultLanguage;
    @Builder.Default
    private Map<Language, String> i18Names = new HashMap<>();
}
