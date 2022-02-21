package com.epam.spring.library.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Schema(title = "Author schema")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AuthorDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @JsonAlias("name")
    @NotBlank(message = "{author.name.empty}")
    private String defaultName;

    @JsonAlias("language")
    @NotBlank(message = "{author.language.empty}")
    private String defaultLanguage;
}
