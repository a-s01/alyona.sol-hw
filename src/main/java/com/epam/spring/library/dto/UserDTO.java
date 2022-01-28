package com.epam.spring.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String email;
    private String role;
    private String state;
    private double fine;
    private String name;
    private LanguageDTO preferredLanguage;
}
