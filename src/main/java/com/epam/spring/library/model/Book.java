package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.time.Year;
import java.util.List;

@Data
@Builder
public class Book {
    private int id;
    private String title;
    private String isbn;
    private Year year;
    private String langCode;
    private int keepPeriod;
    private List<Author> authors;
}
