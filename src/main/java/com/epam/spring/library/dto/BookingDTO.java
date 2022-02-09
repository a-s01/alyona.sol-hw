package com.epam.spring.library.dto;

import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import com.epam.spring.library.model.Booking.Place;
import com.epam.spring.library.model.Booking.State;
import com.epam.spring.library.validation.constraint.EnumValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@Validated
@JsonInclude(NON_ABSENT)
public class BookingDTO {
    @JsonProperty(access = READ_ONLY)
    private int id;

    @NotNull(message = "{booking.user.empty}", groups = OnCreate.class)
    @Null(message = "{booking.user.read.only}", groups = OnUpdate.class)
    private UserDTO user;

    @EnumValue(of = State.class, groups = {OnCreate.class, OnUpdate.class})
    private String state;

    @EnumValue(of = Place.class, groups = {OnCreate.class, OnUpdate.class})
    private String located;
}
