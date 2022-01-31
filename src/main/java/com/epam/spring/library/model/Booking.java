package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Booking implements Entity {
    private int id;
    private User user;
    @Builder.Default
    private State state = State.NEW;
    @Builder.Default
    private Place located = Place.LIBRARY;
    @Builder.Default
    private List<Book> books = new ArrayList<>();

    public enum State {
        UNKNOWN, NEW, BOOKED, DELIVERED, DONE, CANCELED
    }

    public enum Place {
        UNKNOWN, LIBRARY, USER
    }
}
