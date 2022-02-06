package com.epam.spring.library.dto;

import com.epam.spring.library.validation.PublicationYear;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class BookDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    @NotBlank(message = "Book title must be not blank")
    private String title;

    @NotBlank(message = "Book ISBN must be not blank")
    @ISBN
    private String isbn;
    private int year;

    @JsonAlias("language")
    @NotBlank(message = "Book language must be not blank")
    private String langCode;
    // TODO write custom validation for this
    private int keepPeriod;
}
