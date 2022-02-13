package com.epam.spring.library.dto;

import com.epam.spring.library.validation.constraint.PublicationYear;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Schema(title = "Book schema")
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

    @Schema(description = "book publication year")
    @NotBlank(message = "{book.publication.year.empty}")
    @PublicationYear
    private int year;

    @JsonAlias("language")
    @NotBlank(message = "{book.language.empty}")
    private String langCode;

    @Positive(message = "{book.keep.period.invalid}")
    private Integer keepPeriod;
}
