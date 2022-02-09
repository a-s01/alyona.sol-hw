package com.epam.spring.library.dto;

import com.epam.spring.library.validation.constrain.PublicationYear;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class BookDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    @NotBlank(message = "{book.title.empty}")
    private String title;

    @NotBlank(message = "{book.isbn.empty}")
    @ISBN
    private String isbn;

    @PublicationYear
    private int year;

    @JsonAlias("language")
    @NotBlank(message = "{book.language.empty}")
    private String langCode;

    @Positive(message = "{book.keep.period.invalid}")
    private Integer keepPeriod;
}
