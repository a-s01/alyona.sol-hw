package com.epam.spring.library.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Calendar;

@Data
@ToString(exclude = {"password", "salt"})
@Builder
public class User {
    private int id;
    private String email;
    private String password;
    private String salt;
    @Builder.Default
    private Role role = Role.USER;
    @Builder.Default
    private State state = State.VALID;
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

    /**
     * For avoiding password and salt leak through Builder toString() method,
     * we should override it
     */
    public static class UserBuilder {
        @Override
        public String toString() {
            return "UserBuilder(***)";
        }
    }
}
