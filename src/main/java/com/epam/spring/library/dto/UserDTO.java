package com.epam.spring.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class UserDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    private String email;
    private String role;
    private String state;
    private double fine;
    private String name;
    private String preferredLanguage;
}
