package com.epam.spring.library.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Booking {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private State state = State.NEW;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Place located = Place.LIBRARY;

    @ManyToMany
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();

    public enum State {
        @Hidden UNKNOWN, NEW, BOOKED, DELIVERED, DONE, CANCELED
    }

    public enum Place {
        @Hidden UNKNOWN, LIBRARY, USER
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Booking other = (Booking) o;
        return id != 0 && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
