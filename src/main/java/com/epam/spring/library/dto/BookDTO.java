package com.epam.spring.library.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookDTO {
    private String title;
    private String isbn;
    private int year;
    private String langCode;
    private int keepPeriod;
    private List<AuthorDTO> authors;
}
