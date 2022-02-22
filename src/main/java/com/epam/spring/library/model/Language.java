package com.epam.spring.library.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Jacksonized
public class Language {

    @Id
    private int id;

    @Column(nullable = false, unique = true)
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Language other = (Language) o;
        return code != null && Objects.equals(code, other.code);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
