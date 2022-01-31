package com.epam.spring.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class BookingDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;
    private UserDTO user;
    private String state;
    private String located;
}
