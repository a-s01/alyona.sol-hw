package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Booking implements Entity {
    private int id;
    private User user;
    private State state;
    private Place located;
    private List<Book> books;

    public enum State {
        UNKNOWN, NEW, BOOKED, DELIVERED, DONE, CANCELED
    }

    public enum Place {
        UNKNOWN, LIBRARY, USER
    }
}
