package com.epam.spring.library.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Calendar;

@Data
@ToString(exclude = {"password", "salt"})
@Builder
public class User implements Entity {
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
        @Hidden UNKNOWN, USER, LIBRARIAN, ADMIN
    }

    /**
     * User states
     */
    public enum State {
        @Hidden UNKNOWN, VALID, BLOCKED, @Hidden DELETED
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
