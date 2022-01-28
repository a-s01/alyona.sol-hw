package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;

import java.util.Calendar;

@Data
@Builder
public class User {
    private int id;
    private String email;
    private String password;
    private String salt;
    private Role role;
    private State state;
    private double fine;
    private String name;
    private Language preferredLanguage;
    private Calendar fineLastChecked;

    /**
     * User roles used in authorization
     */
     public enum Role {
        UNKNOWN, USER, LIBRARIAN, ADMIN
    }

    /**
     * User states
     */
     public enum State {
        UNKNOWN, VALID, BLOCKED, DELETED
    }
}
