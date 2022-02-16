package com.epam.spring.library.model;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Jacksonized
public class Language {

    @Id
    private int id;

    @Column(nullable = false, unique = true)
    private String code;
}
