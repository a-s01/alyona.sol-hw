package com.epam.spring.library.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
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

    @OneToMany
    private List<Book> books = new ArrayList<>();

    public enum State {
        @Hidden UNKNOWN, NEW, BOOKED, DELIVERED, DONE, CANCELED
    }

    public enum Place {
        @Hidden UNKNOWN, LIBRARY, USER
    }
}
