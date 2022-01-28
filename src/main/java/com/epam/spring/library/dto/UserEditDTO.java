package com.epam.spring.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEditDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String state;
    private String name;
    private LanguageDTO preferredLanguage;
}
