package com.epam.spring.library.model;

import io.swagger.v3.oas.annotations.Hidden;
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
        @Hidden UNKNOWN, NEW, BOOKED, DELIVERED, DONE, CANCELED
    }

    public enum Place {
        @Hidden UNKNOWN, LIBRARY, USER
    }
}
