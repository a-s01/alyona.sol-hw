package com.epam.spring.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    private final Set<AuthorTranslation> nameTranslations = new HashSet<>();
}
