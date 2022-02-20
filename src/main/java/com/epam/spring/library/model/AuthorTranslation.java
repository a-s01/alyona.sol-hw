package com.epam.spring.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AuthorTranslation {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    private String name;

    public AuthorTranslation() {}

    public AuthorTranslation(Language language, String name) {
        this.language = language;
        this.name = name;
    }
}
