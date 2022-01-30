package com.epam.spring.library.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class BookDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    private String title;
    private String isbn;
    private int year;
    @JsonAlias("language")
    private String langCode;
    private int keepPeriod;
    private List<AuthorDTO> authors;
}
