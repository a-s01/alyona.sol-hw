package com.epam.spring.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Language language;

    @Transient
    private final Map<Language, String> nameTranslations = new HashMap<>();
}
