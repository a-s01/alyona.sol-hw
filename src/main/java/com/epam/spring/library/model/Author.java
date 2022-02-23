package com.epam.spring.library.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    private Language language;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private final Set<AuthorTranslation> nameTranslations = new HashSet<>();

    /**
     * Hibernate helper method. Reassure association will be set up on both
     * sides
     * @param translation New AuthorTranslation to add
     */
    public void addNameTranslation(AuthorTranslation translation) {
        translation.setAuthor(this);
        nameTranslations.add(translation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Author other = (Author) o;
        return name != null && Objects.equals(name, other.name);
    }

    /**
     * As we use generated keys and cannot ensure field 'name' will be not
     * null in pure JPA, let it be constant hashcode.
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
