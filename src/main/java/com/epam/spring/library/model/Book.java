package com.epam.spring.library.model;

import com.epam.spring.library.model.conventer.YearConverter;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    @Convert(converter = YearConverter.class)
    private Year year;

    @Column(nullable = false)
    private String langCode;

    @Column(nullable = false)
    private int keepPeriod;

    @ManyToMany
    @ToString.Exclude
    private final Set<Author> authors = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Book other = (Book) o;
        return isbn != null && Objects.equals(isbn, other.isbn);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
