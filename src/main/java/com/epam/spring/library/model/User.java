package com.epam.spring.library.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Getter
@Setter
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

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private State state = State.VALID;

    @Column(nullable = false)
    private double fine;

    private String name;

    @ManyToOne
    private Language preferredLanguage;

    @Temporal(TemporalType.TIMESTAMP)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        User other = (User) o;
        return email != null && Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
