package com.epam.spring.library.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class AuthorDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    @JsonAlias("name")
    private String defaultName;
    @JsonAlias("language")
    private String defaultLanguage;
    private Map<String, String> i18Names;
}
