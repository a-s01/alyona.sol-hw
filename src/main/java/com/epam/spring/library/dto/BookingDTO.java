package com.epam.spring.library.dto;

import com.epam.spring.library.dto.group.OnCreate;
import com.epam.spring.library.dto.group.OnUpdate;
import com.epam.spring.library.model.Booking.Place;
import com.epam.spring.library.model.Booking.State;
import com.epam.spring.library.validation.constraint.EnumValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Schema(title = "Booking schema")
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

    @Schema(allowableValues = {"NEW",
                               "BOOKED",
                               "CANCELED",
                               "DELIVERED",
                               "DONE"})
    @EnumValue(of = State.class, groups = {OnCreate.class, OnUpdate.class})
    private String state;

    @Schema(allowableValues = {"LIBRARY", "USER"})
    @EnumValue(of = Place.class, groups = {OnCreate.class, OnUpdate.class})
    private String located;
}
