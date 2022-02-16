package com.epam.spring.library.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@ToString(exclude = {"password", "salt"})
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private Role role = Role.USER;

    @Column(nullable = false)
    private State state = State.VALID;

    @Column(nullable = false)
    private double fine;

    private String name;

    @ManyToOne
    private Language preferredLanguage;
    private Calendar fineLastChecked;

    /**
     * User roles used in authorization
     */
    public enum Role {
        @Hidden UNKNOWN, USER, LIBRARIAN, ADMIN
    }

    /**
     * User states
     */
    public enum State {
        @Hidden UNKNOWN, VALID, BLOCKED, @Hidden DELETED
    }
}
