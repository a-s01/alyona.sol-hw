package com.epam.spring.library.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(exclude = {"password", "confirmPassword"})
public class UserEditDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String state;
    private String name;
    private LanguageDTO preferredLanguage;

    /**
     * For avoiding password and salt leak through Builder toString() method,
     * we should override it
     */
    public static class UserEditDTOBuilder {
        @Override
        public String toString() {
            return "UserEditDTOBuilder(***)";
        }
    }
}
