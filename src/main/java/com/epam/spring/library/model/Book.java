package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Book implements Entity {
    private int id;
    private String title;
    private String isbn;
    private Year year;
    private String langCode;
    private int keepPeriod;
    @Builder.Default
    private Set<Author> authors = new HashSet<>();
}
