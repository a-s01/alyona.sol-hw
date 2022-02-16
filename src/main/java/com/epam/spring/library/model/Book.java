package com.epam.spring.library.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private Year year;

    @Column(nullable = false)
    private String langCode;

    @Column(nullable = false)
    private int keepPeriod;

    @OneToMany
    private final Set<Author> authors = new HashSet<>();
}
