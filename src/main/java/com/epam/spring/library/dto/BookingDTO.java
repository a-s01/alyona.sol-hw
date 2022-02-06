package com.epam.spring.library.dto;

import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@Validated
public class BookingDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @NotNull(message = "Booking owner/user cannot be blank",
             groups = OnCreate.class)
    @Null(message = "Booking user cannot be changed", groups = OnUpdate.class)
    private UserDTO user;
    private String state;
    private String located;
}
